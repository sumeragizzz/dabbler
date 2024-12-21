package dev.sumeragizzz.dabbler.core.service;

import dev.sumeragizzz.dabbler.persistence.entity.MedicalReceipt;
import dev.sumeragizzz.dabbler.persistence.repository.MedicalReceiptRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicalReceiptService {

    private final EntityManager entityManager;

    private final MedicalReceiptRepository repository;

    public MedicalReceiptService(EntityManager entityManager, MedicalReceiptRepository repository) {
        this.entityManager = entityManager;
        this.repository = repository;
    }

    public List<MedicalReceipt> getMedicalReceipt() {
        return repository.findAll();
    }

    public Optional<MedicalReceipt> getMedicalReceipt(Long medicalReceiptId) {
        return repository.findById(medicalReceiptId);
    }

    public List<MedicalReceipt> getMedicalReceipt(List<Long> medicalReceiptIds) {
        return repository.findAllById(medicalReceiptIds);
    }

    public MedicalReceipt addMedicalReceipt(MedicalReceipt entity) {
        if (entity.getId() != null) {
            throw new IllegalArgumentException();
        }

        return repository.save(entity);
    }

    public MedicalReceipt updateMedicalReceipt(MedicalReceipt entity) {
        if (entity.getId() == null) {
            throw new IllegalArgumentException();
        }

        entityManager.merge(entity);
        return repository.save(entity);
    }

    public void deleteMedicalReceipt(Long medicalReceiptId) {
        repository.deleteById(medicalReceiptId);
    }

}
