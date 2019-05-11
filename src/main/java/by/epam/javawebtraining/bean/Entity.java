package by.epam.javawebtraining.bean;

import by.epam.javawebtraining.dao.daointerface.IDdefinition;

public class Entity {
    protected int id;

    protected Entity() {
    }

    protected Entity(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
