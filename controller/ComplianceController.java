package sda_pro_java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sda_pro_java.compliance.ComplianceReport;
import sda_pro_java.compliance.ComplianceService;
import sda_pro_java.service.SdaProService;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService complianceService;
    private final SdaProService sdaProService;

    public ComplianceController(
            ComplianceService complianceService,
            SdaProService sdaProService) {

        this.complianceService = complianceService;
        this.sdaProService = sdaProService;
    }

    @GetMapping("/soc2")
    public ComplianceReport soc2Report() {

        return complianceService.generateSoc2Report(
                sdaProService.getIncidentCount()
        );
    }

    @GetMapping("/gdpr")
    public ComplianceReport gdprReport() {

        return complianceService.generateGdprReport(
                sdaProService.getIncidentCount()
        );
    }
}