package com.tp3.persistence;

import com.tp3.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByGenre(String genre);
    List<Document> findByAuteur(String auteur);
    List<Document> findByTitreContains(String titre);

    @Query("select c from Document c where YEAR(c.datePub) =:anneePub")
    List<Document> findByAnnePub(@Param(("anneePub"))int text);
}
