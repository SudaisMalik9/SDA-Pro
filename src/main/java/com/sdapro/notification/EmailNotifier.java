package com.sdapro.notification;

// PATTERN: Simple Notification Service
/**
 * Simple service responsible for sending security alerts to stakeholders.
 * Represents the notification service subsystem.
 */
public class EmailNotifier {

    /**
     * Send an email notification about an incident.
     *
     * @param recipient The recipient email address.
     * @param subject   The email subject.
     * @param body      The main body text of the alert.
     */
    public void sendEmailAlert(String recipient, String subject, String body) {
        System.out.println("\n[NOTIFICATION: Email] Sending security dispatch...");
        System.out.println("  To:      " + recipient);
        System.out.println("  Subject: " + subject);
        System.out.println("  Content: " + body);
        System.out.println("[NOTIFICATION: Email] Dispatch successfully sent.");
    }
}
