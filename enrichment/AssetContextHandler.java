package sda_pro_java.enrichment;

// Adds asset criticality context
public class AssetContextHandler extends EnrichmentHandler {

    @Override
    protected EnrichmentContext process(EnrichmentContext context) {
        context.setGeoLocation(
                context.getGeoLocation() + " | Asset Criticality: HIGH"
        );
        return context;
    }
}