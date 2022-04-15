package com.tp3.persistence;

import com.tp3.DTO.ClientDTO;
import com.tp3.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Long countByIdUser ( Long id );

}
