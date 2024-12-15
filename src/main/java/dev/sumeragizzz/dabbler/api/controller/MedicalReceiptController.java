package dev.sumeragizzz.dabbler.api.controller;

import dev.sumeragizzz.dabbler.core.constant.ReceiptType;
import dev.sumeragizzz.dabbler.core.model.MedicalReceipt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/medical-receipt")
public class MedicalReceiptController {

    @GetMapping
    public MedicalReceipt getMedicalReceiptAll() {
        return new MedicalReceipt("name", "institution", ReceiptType.EXAMINATION, BigDecimal.ZERO);
    }

    @GetMapping("/{medicalReceiptId}")
    public MedicalReceipt getMedicalReceiptById(@PathVariable String medicalReceiptId) {
        return new MedicalReceipt("name", "institution", ReceiptType.EXAMINATION, BigDecimal.ZERO);
    }

}
