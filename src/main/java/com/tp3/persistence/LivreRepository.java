package com.tp3.persistence;

import com.tp3.model.LivreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<LivreDTO, Long> { }
