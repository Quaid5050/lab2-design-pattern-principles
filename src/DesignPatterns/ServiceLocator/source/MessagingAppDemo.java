package DesignPatterns.ServiceLocator.source;


// Main Class
public class MessagingAppDemo {
    public static void main(String[] args) {
        System.out.println("--- Messaging Application ---");

        // Using Service Locator pattern to fetch services
        NotificationService emailService = NotificationServiceLocator.getService("EmailService");
        NotificationService smsService = NotificationServiceLocator.getService("SmsService");

        emailService = NotificationServiceLocator.getService("EmailService");
        smsService = NotificationServiceLocator.getService("SmsService");

        // Decorate services with Encryption, DigitalSignature, or both
        NotificationService encryptedEmailService = new EncryptionDecorator(emailService);
        NotificationService signedEmailService = new DigitalSignatureDecorator(emailService);
        NotificationService encryptedAndSignedSmsService = new DigitalSignatureDecorator(new EncryptionDecorator(smsService));


        // Simulating Messaging Application
        System.out.println("\n-- Sending Notifications --");
        encryptedEmailService.sendNotification("Secure Email");
        signedEmailService.sendNotification("Email with Digital Signature");
        encryptedAndSignedSmsService.sendNotification("Secure SMS");


    }
}
