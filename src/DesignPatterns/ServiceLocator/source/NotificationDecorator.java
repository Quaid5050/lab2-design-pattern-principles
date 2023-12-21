package DesignPatterns.ServiceLocator.source;

// Decorator Pattern - Adding Decorators for Services
abstract class NotificationDecorator implements NotificationService {
    protected NotificationService decoratedService;

    public NotificationDecorator(NotificationService decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public String getName() {
        return decoratedService.getName();
    }

    @Override
    public void sendNotification(String message) {
        decoratedService.sendNotification(message);
    }
}
