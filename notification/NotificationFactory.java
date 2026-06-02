package sda_pro_java.notification;

// PATTERN: Abstract Factory
public interface NotificationFactory {

    Notifier createEmailNotifier();

    Notifier createSlackNotifier();
}