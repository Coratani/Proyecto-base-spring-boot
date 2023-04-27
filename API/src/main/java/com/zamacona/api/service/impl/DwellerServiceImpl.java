package com.zamacona.api.service.impl;

import com.zamacona.api.entities.Dweller;
import com.zamacona.api.repositories.DwellerRepository;
import com.zamacona.api.service.DwellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DwellerServiceImpl implements DwellerService {
    @Autowired
    private DwellerRepository dwellerRepository;

    public List<Dweller> listDwellers(){
        return dwellerRepository.findAll();
    }
    public void saveDweller(Dweller dweller){
        dwellerRepository.save(dweller);
    }

    public Optional<Dweller> getDwellerById(Integer id){
        return dwellerRepository.findByDwellerNumber(id);
    }
    public void deleteDweller(Integer id){
        dwellerRepository.deleteByDwellerNumber(id);
    }

}
