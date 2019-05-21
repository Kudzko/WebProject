package by.epam.javawebtraining.service;

import by.epam.javawebtraining.service.impementations.UserService;

public enum ServiceType {
    USER_SERVICE(new UserService());

    private AbstractService service;



    ServiceType(AbstractService service) {
        this.service = service;
    }

    public AbstractService getService(){
        return service;
    }
}
