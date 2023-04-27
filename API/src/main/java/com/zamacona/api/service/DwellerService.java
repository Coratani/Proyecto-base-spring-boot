package com.zamacona.api.service;


import com.zamacona.api.entities.Dweller;

import java.util.List;
import java.util.Optional;


public interface DwellerService {

    List<Dweller> listDwellers();

    void saveDweller(Dweller dweller);

    Optional<Dweller> getDwellerById(Integer dwellerNumber);

    void deleteDweller(Integer id);
}
