package sda_pro_java.event;

public class AuditObserver implements Observer {

    @Override
    public void update(String event) {
        System.out.println("Audit saved: " + event);
    }
}