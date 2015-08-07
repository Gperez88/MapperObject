package repository;

import mapper.Mapping;

/**
 * Created by gabriel on 8/5/2015.
 */
public abstract class BaseColumn {
    @Mapping
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
