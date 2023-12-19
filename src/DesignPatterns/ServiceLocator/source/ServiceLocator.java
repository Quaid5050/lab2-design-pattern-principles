package DesignPatterns.ServiceLocator.source;

import DesignPatterns.ServiceLocator.source.Cache;
import DesignPatterns.ServiceLocator.source.InitialContext;
import DesignPatterns.ServiceLocator.source.Service;

public class ServiceLocator {
    private static final Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String name) {
        Service service = cache.getService(name);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        service = (Service) context.lookup(name);
        if (service != null) {
            cache.addService(service);
        }

        return service;
    }

}
