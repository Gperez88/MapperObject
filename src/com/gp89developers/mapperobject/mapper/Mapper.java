package com.gp89developers.mapperobject.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by gabriel on 2/27/2016.
 */
public abstract class Mapper {
    /**
     * this method to map object
     *
     * @param source
     * @param destination
     * @param <TDestination>
     * @return new instance destination object
     */
    public static <TDestination> TDestination map(Object source, TDestination destination) {
        try {

            List<Field> annotationFields = new ArrayList<>();

            if (source.getClass().isAnnotationPresent(EntityMapper.class)) {
                annotationFields = getAllDeclaredField(source.getClass());
            } else if (destination.getClass().isAnnotationPresent(EntityMapper.class)) {
                annotationFields = getAllDeclaredField(destination.getClass());
            }

            for (Field field : annotationFields) {
                if (!field.isAnnotationPresent(Mapping.class))
                    continue;

                Mapping mapping = field.getAnnotation(Mapping.class);
                String fieldName = !mapping.name().equals("") ? mapping.name() : field.getName();

                Field toField = findFieldByName(destination.getClass(), fieldName);
                Field fromField = findFieldByName(source.getClass(), fieldName);

                if (toField == null || fromField == null)
                    continue;

                toField.setAccessible(true);
                fromField.setAccessible(true);

                boolean isEqualType = !mapping.otherType();
                boolean isIterable = !fromField.getType().isPrimitive() && Class.forName(fromField.getType().getName()).equals(List.class);
                boolean isOtherType = !isEqualType && !isIterable;
                boolean isInvalidField = fromField.get(source) == null || Modifier.isFinal(fromField.getModifiers());

                if (isInvalidField)
                    continue;

                if (isEqualType) {
                    toField.set(destination, fromField.get(source));
                }

                if (isIterable) {
                    Object[] fromFieldValues = ((Collection) fromField.get(source)).toArray();
                    ParameterizedType integerListType = (ParameterizedType) toField.getGenericType();
                    Class<?> toFieldClass = (Class<?>) integerListType.getActualTypeArguments()[0];
                    Collection<Object> toFieldCollection = new ArrayList<>();

                    for (Object fromFieldValue : fromFieldValues) {
                        toFieldCollection.add(map(fromFieldValue, toFieldClass));
                    }

                    toField.set(destination, toFieldCollection);
                }

                if (isOtherType) {
                    Object value = map(fromField.get(source), toField.getType());
                    toField.set(destination, value);
                }
            }
            return destination;
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }

        return null;
    }

    /**
     * this method to map object
     *
     * @param source
     * @param clazz
     * @param <TDestination>
     * @return new instance destination object
     */
    public static <TDestination> TDestination map(Object source, Class<TDestination> clazz) {
        try {
            return map(source, clazz.newInstance());
        } catch (InstantiationException e) {
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            // e.printStackTrace();
        }
        return null;
    }

    /**
     * this method get all field.
     *
     * @param clazz
     * @return field list
     */
    private static List<Field> getAllDeclaredField(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();

        Class<?> typeClazz = clazz;
        while (typeClazz != null && typeClazz != Object.class) {
            fields.addAll(Arrays.asList(typeClazz.getDeclaredFields()));
            typeClazz = typeClazz.getSuperclass();
        }

        return fields;
    }

    /**
     * find field by name
     *
     * @param clazz
     * @param fieldName
     * @return field
     */
    private static Field findFieldByName(Class<?> clazz, String fieldName) {

        Class<?> typeClazz = clazz;
        while (typeClazz != null && typeClazz != Object.class) {
            try {
                return typeClazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                // e.printStackTrace();

                // if no such field then find annotation name param.
                Field[] fields = typeClazz.getDeclaredFields();

                if (fields.length == 0)
                    return null;

                for (Field field : fields) {
                    if (field.isAnnotationPresent(Mapping.class)) {
                        Mapping mapping = field.getAnnotation(Mapping.class);
                        if (mapping == null || mapping.name().equals(""))
                            continue;

                        if (mapping.name().equals(fieldName))
                            return field;
                    }
                }
                typeClazz = typeClazz.getSuperclass();
            }
        }

        return null;
    }
}