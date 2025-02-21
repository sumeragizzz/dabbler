package dev.sumeragizzz.dabbler.web.form;

import dev.sumeragizzz.dabbler.persistence.entity.MedicalReceipt;

import java.util.ArrayList;
import java.util.List;

public class MedicalReceiptConfirmDeleteForm {

    private List<MedicalReceipt> medicalReceipts;

    public MedicalReceiptConfirmDeleteForm() {
        this.medicalReceipts = new ArrayList<>();
    }

    public List<MedicalReceipt> getMedicalReceipts() {
        return medicalReceipts;
    }

    public void setMedicalReceipts(List<MedicalReceipt> medicalReceipts) {
        this.medicalReceipts = medicalReceipts;
    }

}
