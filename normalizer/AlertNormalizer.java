package sda_pro_java.normalizer;

import sda_pro_java.domain.SingleAlert;
import sda_pro_java.dto.RawAlertRequest;

public interface AlertNormalizer {

    SingleAlert normalize(RawAlertRequest request);
}