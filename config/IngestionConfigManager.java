package sda_pro_java.config;

import java.util.List;

// PATTERN: Singleton
public class IngestionConfigManager {

    private static IngestionConfigManager instance;

    private final List<String> enabledSources =
            List.of("splunk", "firewall", "crowdstrike", "threatfeed");

    private IngestionConfigManager() {
    }

    public static synchronized IngestionConfigManager getInstance() {

        if (instance == null) {
            instance = new IngestionConfigManager();
        }

        return instance;
    }

    public boolean isSourceEnabled(String source) {
        return enabledSources.contains(source.toLowerCase());
    }
}