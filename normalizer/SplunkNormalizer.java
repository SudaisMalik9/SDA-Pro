package sda_pro_java.normalizer;

import sda_pro_java.domain.Severity;
import sda_pro_java.domain.SingleAlert;
import sda_pro_java.dto.RawAlertRequest;

// PATTERN: Factory Method Product
public class SplunkNormalizer implements AlertNormalizer {

    @Override
    public SingleAlert normalize(RawAlertRequest request) {

        Severity severity =
                Severity.valueOf(request.getSeverity().toUpperCase());

        return new SingleAlert(
                "splunk",
                severity,
                request.getIp(),
                request.getMessage()
        );
    }
}