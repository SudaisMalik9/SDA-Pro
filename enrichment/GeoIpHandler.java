package sda_pro_java.enrichment;

public class GeoIpHandler extends EnrichmentHandler {

    @Override
    protected EnrichmentContext process(EnrichmentContext context) {
        context.setGeoLocation("Lahore, Pakistan");
        return context;
    }
}