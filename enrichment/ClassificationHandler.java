package sda_pro_java.enrichment;

import sda_pro_java.domain.Severity;

public class ClassificationHandler extends EnrichmentHandler {

    @Override
    protected EnrichmentContext process(EnrichmentContext context) {

        if (context.getThreatScore() >= 80) {
            context.setFinalSeverity(Severity.CRITICAL);
        }

        return context;
    }
}