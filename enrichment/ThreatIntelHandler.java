package sda_pro_java.enrichment;

import sda_pro_java.threat.ThreatIntelProxy;
import sda_pro_java.threat.VirusTotalAdapter;

public class ThreatIntelHandler extends EnrichmentHandler {

    @Override
    protected EnrichmentContext process(EnrichmentContext context) {

        ThreatIntelProxy proxy =
                new ThreatIntelProxy(new VirusTotalAdapter());

        int score =
                proxy.reputationScore(context.getAlert().getIp());

        context.setThreatScore(score);

        return context;
    }
}