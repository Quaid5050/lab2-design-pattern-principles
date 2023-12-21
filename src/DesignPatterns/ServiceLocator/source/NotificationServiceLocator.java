package DesignPatterns.ServiceLocator.source;

// Service Locator with Cache
class NotificationServiceLocator {
    private static final ServiceCache serviceCache = new ServiceCache();
    private static final InitialContext context = new InitialContext();

    public static NotificationService getService(String serviceName) {
        NotificationService service = serviceCache.getService(serviceName);

        if (service == null) {
            System.out.println("Service not found in cache. Fetching from the locator.");

            // Lookup in InitialContext
            Object serviceObject = context.lookup(serviceName);
            if (serviceObject instanceof NotificationService) {
                service = (NotificationService) serviceObject;
                serviceCache.addService(serviceName, service);
            }
        } else {
            System.out.println("Returning " + serviceName + " from cache.");
        }

        return service;
    }
}
