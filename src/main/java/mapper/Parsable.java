package mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 2/28/2016.
 */
public abstract class Parsable<D, T extends Parsable> {

    public abstract Class<D> getDomainClass();

    public D parse() {
        return Mapper.map(this, getDomainClass());
    }

    public void load(D domain) {
        Mapper.map(domain, this);
    }

    @SuppressWarnings("unchecked")
    public List<T> getViewList(List<D> domainList) {
        List<T> viewList = new ArrayList<>();

        for (D domain : domainList) {
            try {
                T newType = (T) getClass().newInstance();
                newType.load(domain);
                viewList.add(newType);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return viewList;
    }

    @SuppressWarnings("unchecked")
    public List<D> getDomainList(List<T> viewList) {
        List<D> domainList = new ArrayList<>();

        for (T type : viewList) {
            D newDomain = (D) type.parse();
            domainList.add(newDomain);
        }

        return domainList;
    }
}