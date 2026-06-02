package sda_pro_java.event;

import java.util.ArrayList;
import java.util.List;

// PATTERN: Observer + Singleton
public class EventBusPublisher {

    private static EventBusPublisher instance;

    private final List<Observer> observers = new ArrayList<>();

    private EventBusPublisher() {
        observers.add(new DashboardObserver());
        observers.add(new AuditObserver());
    }

    public static synchronized EventBusPublisher getInstance() {

        if (instance == null) {
            instance = new EventBusPublisher();
        }

        return instance;
    }

    public void publish(String event) {

        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}