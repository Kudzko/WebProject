package by.epam.javawebtraining.bean;

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
