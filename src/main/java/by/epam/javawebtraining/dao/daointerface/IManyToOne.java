package by.epam.javawebtraining.dao.daointerface;

import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.Connection;

/**
 * @param <Owner>      Class witch has reference to dependency object
 * @param <Dependence> Class of dependency object
 */

public interface IManyToOne<Owner extends  IDdefinition, Dependence extends IDdefinition> {


    public Dependence getDependence(Owner owner) throws IllegalAccessException;

    public void setDependence(Owner owner, Dependence dependence) throws IllegalAccessException;

    public Dependence createDependence(Connection connection, Owner owner) throws DAOException, IllegalAccessException;

    public void updateDependence (Connection connection, Owner owner) throws
    DAOException, IllegalAccessException;

}
