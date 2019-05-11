package by.epam.javawebtraining.dao;

import by.epam.javawebtraining.dao.daointerface.IDdefinition;
import by.epam.javawebtraining.dao.daointerface.IFactoryDAO;
import by.epam.javawebtraining.dao.daointerface.IManyToOne;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.lang.reflect.Field;
import java.sql.Connection;


/**
 * Used to provide relations Many to one
 */

public class ManyToOne<Owner extends  IDdefinition, Dependence extends IDdefinition>
        implements IManyToOne<Owner , Dependence>{
    private IFactoryDAO factory;
    private Field field;
    private String name;
    private int hash;

    public ManyToOne(Class<Owner> ownwerClass, IFactoryDAO factory, String field) throws NoSuchFieldException {
        this.factory = factory;
        this.field = ownwerClass.getDeclaredField(field);

        this.name = ownwerClass.getSimpleName() + " to " + this.field.getType
                ().getSimpleName();
        this.hash = ownwerClass.hashCode() & field.hashCode();
    }

    @Override
    public Dependence getDependence(Owner owner) throws IllegalAccessException {
        return (Dependence) field.get(owner);
    }

    @Override
    public void setDependence(Owner owner, Dependence dependence) throws IllegalAccessException {
        field.set(owner, dependence);
    }

    @Override
    public Dependence createDependence(Connection connection, Owner owner) throws
            DAOException, IllegalAccessException {
        return (Dependence) factory.getDAO(field.getType()).persist
                (getDependence(owner));
    }

    @Override
    public void updateDependence(Connection connection, Owner owner) throws
            DAOException, IllegalAccessException {
        factory.getDAO(field.getType()).update(getDependence(owner));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
