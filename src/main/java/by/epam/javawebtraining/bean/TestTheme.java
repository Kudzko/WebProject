package by.epam.javawebtraining.bean;

import java.util.Objects;

public class TestTheme {
    private Long id;
    private String theme;

    public TestTheme() {
    }

    public TestTheme(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass())){ return false;}
        TestTheme testTheme = (TestTheme) o;
        return Objects.equals(id, testTheme.id) &&
                Objects.equals(theme, testTheme.theme);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, theme);
    }

    @Override
    public String toString() {
        return "TestTheme{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                '}';
    }
}
