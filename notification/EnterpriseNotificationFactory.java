package sda_pro_java.notification;

// PATTERN: Abstract Factory
public class EnterpriseNotificationFactory
        implements NotificationFactory {

    @Override
    public Notifier createEmailNotifier() {
        return new EmailNotifier();
    }

    @Override
    public Notifier createSlackNotifier() {
        return new SlackNotifier();
    }
}