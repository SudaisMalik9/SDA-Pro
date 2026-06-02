package sda_pro_java.notification;

public class EmailNotifier implements Notifier {

    @Override
    public String send(String message) {
        return "Email sent: " + message;
    }
}