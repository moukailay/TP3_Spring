package com.tp3.persistence;

import com.tp3.model.PretDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PretDocumentRepository extends JpaRepository<PretDocument, Long> {
    List<PretDocument> findByStatutRetour(String statut);
    int countByIdPret ( Long id);
}
