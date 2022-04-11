package com.tp3.persistence;

import com.tp3.model.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DvdRepository extends JpaRepository<Dvd, Long> { }
