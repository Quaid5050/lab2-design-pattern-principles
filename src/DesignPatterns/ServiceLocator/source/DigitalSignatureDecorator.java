package DesignPatterns.ServiceLocator.source;

class DigitalSignatureDecorator extends NotificationDecorator {
    public DigitalSignatureDecorator(NotificationService decoratedService) {
        super(decoratedService);
    }

    @Override
    public void sendNotification(String message) {
        String signedMessage = addSignature(message);
        super.sendNotification(signedMessage);
    }

    private String addSignature(String message) {
        // Perform digital signature logic here
        return "Digitally Signed: " + message;
    }
}
