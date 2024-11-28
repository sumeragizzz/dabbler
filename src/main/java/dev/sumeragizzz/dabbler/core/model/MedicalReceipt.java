package dev.sumeragizzz.dabbler.core.model;

import dev.sumeragizzz.dabbler.core.constant.ReceiptType;

import java.math.BigDecimal;

public class MedicalReceipt {

    private final String examineeName;

    private final String medicalInstitutionName;

    private final ReceiptType receiptType;

    private final BigDecimal amount;

    public MedicalReceipt(String examineeName, String medicalInstitutionName, ReceiptType receiptType, BigDecimal amount) {
        this.examineeName = examineeName;
        this.medicalInstitutionName = medicalInstitutionName;
        this.receiptType = receiptType;
        this.amount = amount;
    }

    public String getExamineeName() {
        return examineeName;
    }

    public String getMedicalInstitutionName() {
        return medicalInstitutionName;
    }

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "MedicalReceipt{" +
                "examineeName='" + examineeName + '\'' +
                ", medicalInstitutionName='" + medicalInstitutionName + '\'' +
                ", receiptType=" + receiptType +
                ", amount=" + amount +
                '}';
    }

}
