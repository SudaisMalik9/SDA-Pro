package sda_pro_java.normalizer;

// PATTERN: Factory Method
public class AlertNormalizerFactory {

    public static AlertNormalizer create(String source) {

        return switch (source.toLowerCase()) {

            case "splunk" -> new SplunkNormalizer();

            case "firewall" -> new FirewallNormalizer();

            case "crowdstrike" -> new CrowdStrikeNormalizer();

            case "threatfeed" -> new ThreatFeedNormalizer();

            default -> throw new IllegalArgumentException(
                    "Unsupported source: " + source);
        };
    }
}