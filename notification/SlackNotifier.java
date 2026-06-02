package sda_pro_java.notification;

public class SlackNotifier implements Notifier {

    @Override
    public String send(String message) {
        return "Slack sent: " + message;
    }
}