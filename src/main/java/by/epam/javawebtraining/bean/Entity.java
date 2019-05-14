package by.epam.javawebtraining.bean;

import by.epam.javawebtraining.dao.daointerface.IDdefinition;

public class Entity {
    protected long id;

    protected Entity() {
    }

    protected Entity(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
