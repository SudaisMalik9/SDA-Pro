package sda_pro_java.domain;

import java.util.List;

public interface AlertComponent {

    String getId();

    Severity getSeverity();

    String getMessage();

    void add(AlertComponent component);

    List<AlertComponent> getChildren();
}