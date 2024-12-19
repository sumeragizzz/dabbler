package dev.sumeragizzz.dabbler.core.service;

import dev.sumeragizzz.dabbler.persistence.entity.MedicalReceipt;
import dev.sumeragizzz.dabbler.persistence.repository.MedicalReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalReceiptService {

    private final MedicalReceiptRepository repository;

    public MedicalReceiptService(MedicalReceiptRepository medicalReceiptRepository) {
        this.repository = medicalReceiptRepository;
    }

    public List<MedicalReceipt> getMedicalReceipt() {
        return repository.findAll();
    }

}
