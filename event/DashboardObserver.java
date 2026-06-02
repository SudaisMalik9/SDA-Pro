package sda_pro_java.event;

public class DashboardObserver implements Observer {

    @Override
    public void update(String event) {
        System.out.println("Dashboard updated: " + event);
    }
}