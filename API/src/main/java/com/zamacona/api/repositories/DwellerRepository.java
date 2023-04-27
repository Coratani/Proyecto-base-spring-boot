package com.zamacona.api.repositories;

import com.zamacona.api.entities.Dweller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface DwellerRepository extends JpaRepository<Dweller, Integer> {


    Optional<Dweller> findByDwellerNumber(Integer dwellerNumber);

    @Transactional
    void deleteByDwellerNumber(Integer dwellerNumber);
}
