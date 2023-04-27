package com.zamacona.api.controller.impl;

import com.zamacona.api.controller.DwellerController;
import com.zamacona.api.entities.Dweller;
import com.zamacona.api.repositories.DwellerRepository;
import com.zamacona.api.service.DwellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DwellerControllerImpl implements DwellerController {

    private final DwellerService dwellerService;
    private final DwellerRepository dwellerRepository;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/Dweller")
    public List<Dweller> getDwellers() {
        try {
            return dwellerService.listDwellers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/Dweller/{id}")
    public ResponseEntity<?> getDweller(@PathVariable Integer id){
        try{
            Optional<Dweller> dweller= Optional.ofNullable(dwellerService.getDwellerById(id).orElseThrow(RuntimeException::new));
            return new ResponseEntity<>(dweller,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Dweller doesn't exist",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value="/Dweller")
    public ResponseEntity<?> newDweller(@RequestBody Dweller dweller){

        Dweller dwellerExists = dwellerRepository.findByDwellerNumber(dweller.getDwellerNumber()).orElse(new Dweller());

        if(dwellerExists.getDwellerNumber()==null){
            dwellerService.saveDweller(dweller);
            return new ResponseEntity<>("Dweller created",HttpStatus.ACCEPTED);
        }
        else{
                return new ResponseEntity<>("Dweller already exist",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="/Dweller/{id}")
    public ResponseEntity<?> editDweller(@RequestBody Dweller dweller, @PathVariable Integer id){
        try{
            Dweller dwellerExists = dwellerRepository.findByDwellerNumber(dweller.getDwellerNumber()).orElse(new Dweller());
            dwellerExists.setDwellerNumber(dweller.getDwellerNumber());
            dwellerExists.setName(dweller.getName());
            dwellerExists.setLastName(dweller.getLastName());
            dwellerExists.setHouseHoldMembers(dweller.getHouseHoldMembers());
            dwellerExists.setIncludeAll(dweller.getIncludeAll());
            dwellerExists.setBirthDate(dweller.getBirthDate());
            dwellerExists.setEmail(dweller.getEmail());
            dwellerExists.setVaultLocation(dweller.getVaultLocation());
            dwellerExists.setVaultNumber(dweller.getVaultNumber());
            dwellerExists.setIsCommie(dweller.getIsCommie());
            dwellerService.saveDweller(dwellerExists);
            return new ResponseEntity<>("Dweller edited succesfully", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Dweller doesn't exist",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value="/Dweller/{id}")
    public ResponseEntity<?> deleteDweller(@PathVariable Integer id){
        try{
            dwellerService.deleteDweller(id);
            return new ResponseEntity<>("Dweller deleted",HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>("Dweller doesn't exist",HttpStatus.BAD_REQUEST);
        }
    }















}
