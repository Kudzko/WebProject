package by.epam.javawebtraining.bean;

public class Entity {
    protected int id;

    protected Entity() {
    }

    protected Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
