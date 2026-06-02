package sda_pro_java.normalizer;

import sda_pro_java.domain.Severity;
import sda_pro_java.domain.SingleAlert;
import sda_pro_java.dto.RawAlertRequest;

// PATTERN: Factory Method Product
public class CrowdStrikeNormalizer implements AlertNormalizer {

    @Override
    public SingleAlert normalize(RawAlertRequest request) {
        return new SingleAlert(
                "crowdstrike",
                Severity.valueOf(request.getSeverity().toUpperCase()),
                request.getIp(),
                request.getMessage()
        );
    }
}