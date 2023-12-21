package DesignPatterns.ServiceLocator.source;

import java.util.HashMap;
import java.util.Map;

// Service Cache
class ServiceCache {
    private final Map<String, NotificationService> serviceMap;

    public ServiceCache() {
        this.serviceMap = new HashMap<>();
    }

    public NotificationService getService(String serviceName) {
        return serviceMap.get(serviceName);
    }

    public void addService(String serviceName, NotificationService service) {
        serviceMap.put(serviceName, service);
    }

    public boolean containsService(String serviceName) {
        return serviceMap.containsKey(serviceName);
    }
}
