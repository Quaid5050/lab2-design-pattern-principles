package DesignPatterns.ServiceLocator.source;

class EncryptionDecorator extends NotificationDecorator {
    public EncryptionDecorator(NotificationService decoratedService) {
        super(decoratedService);
    }

    @Override
    public void sendNotification(String message) {
        String encryptedMessage = encrypt(message);
        super.sendNotification(encryptedMessage);
    }

    private String encrypt(String message) {
        // Perform encryption logic here
        return "Encrypted: " + message;
    }
}
