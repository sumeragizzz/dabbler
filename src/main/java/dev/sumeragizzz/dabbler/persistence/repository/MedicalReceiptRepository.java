package dev.sumeragizzz.dabbler.persistence.repository;

import dev.sumeragizzz.dabbler.persistence.entity.MedicalReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReceiptRepository extends JpaRepository<MedicalReceipt, Long> {
}
