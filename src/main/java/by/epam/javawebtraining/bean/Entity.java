package by.epam.javawebtraining.bean;

import java.io.Serializable;

public class Entity implements Serializable {
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
