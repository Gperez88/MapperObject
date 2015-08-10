package mapper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gaperez on 8/5/2015.
 */
public abstract class Mapper {
    public static <TDestination> TDestination map(Object source, Class<TDestination> clazz) {
        try {
            TDestination destination = clazz.newInstance();
            for (Field toField : destination.getClass().getDeclaredFields()) {
                if (toField.isAnnotationPresent(Mapping.class)) {

                    Mapping mapping = toField.getAnnotation(Mapping.class);
                    String fieldName = !mapping.name().equals("") ? mapping.name() : toField.getName();

                    Field fromField = source.getClass().getDeclaredField(fieldName);
                    boolean isEqualType = fromField.getType().equals(toField.getType()) && !mapping.otherType();
                    boolean isOtherType = mapping.otherType() && !Collection.class.isAssignableFrom(fromField.getType());
                    boolean isOtherTypeAndIterable = mapping.otherType() && Collection.class.isAssignableFrom(fromField.getType());

                    toField.setAccessible(true);
                    fromField.setAccessible(true);

                    if (isEqualType) {
                        toField.set(destination, fromField.get(source));
                    } else if (isOtherType) {
                        Object value = map(fromField.get(source), toField.getType());
                        toField.set(destination, value);
                    } else if (isOtherTypeAndIterable) {

                        if (fromField.get(source) != null) {

                            Object[] fromFieldValues = ((Collection) fromField.get(source)).toArray();
                            ParameterizedType integerListType = (ParameterizedType) toField.getGenericType();
                            Class<?> toFieldClass = (Class<?>) integerListType.getActualTypeArguments()[0];
                            Collection<Object> toFieldCollection = new ArrayList<>();

                            for (int index = 0; index < fromFieldValues.length; index++) {
                                Object value = map(fromFieldValues[index], toFieldClass);
                                toFieldCollection.add(value);
                            }

                            toField.set(destination, toFieldCollection);
                        }
                    }
                }
            }
            return destination;
        } catch (IllegalAccessException e) {
            //TODO: implement exception.
        } catch (NoSuchFieldException e) {
            //TODO: implement exception.
        } catch (InstantiationException e) {
            //TODO: implement exception.
        }

        return null;
    }
}
