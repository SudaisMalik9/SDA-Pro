package sda_pro_java.enrichment;

// Adds user identity and privilege context
public class UserIdentityHandler extends EnrichmentHandler {

    @Override
    protected EnrichmentContext process(EnrichmentContext context) {
        context.setGeoLocation(
                context.getGeoLocation() + " | User: admin | Privilege: HIGH"
        );
        return context;
    }
}