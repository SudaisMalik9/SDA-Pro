package sda_pro_java.enrichment;

public class DeduplicationHandler extends EnrichmentHandler {

    @Override
    protected EnrichmentContext process(EnrichmentContext context) {
        context.setDuplicate(false);
        return context;
    }
}