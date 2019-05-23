package by.epam.javawebtraining.service;

import by.epam.javawebtraining.service.impementations.TestService;
import by.epam.javawebtraining.service.impementations.UserService;

public enum ServiceType {
    USER_SERVICE(new UserService()), TEST_SERVICE(new TestService());

    private AbstractService service;



    ServiceType(AbstractService service) {
        this.service = service;
    }

    public AbstractService getService(){
        return service;
    }
}
