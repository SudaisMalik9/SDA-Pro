package sda_pro_java.enrichment;

// PATTERN: Chain of Responsibility
public abstract class EnrichmentHandler {

    private EnrichmentHandler next;

    public EnrichmentHandler setNext(EnrichmentHandler next) {
        this.next = next;
        return next;
    }

    public EnrichmentContext handle(EnrichmentContext context) {

        EnrichmentContext updated = process(context);

        if (next != null) {
            return next.handle(updated);
        }

        return updated;
    }

    protected abstract EnrichmentContext process(EnrichmentContext context);
}