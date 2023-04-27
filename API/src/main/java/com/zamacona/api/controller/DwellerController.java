package com.zamacona.api.controller;

import com.zamacona.api.entities.Dweller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DwellerController {

    List<Dweller> getDwellers();

    ResponseEntity<?> getDweller(@PathVariable Integer id);

    ResponseEntity<?> newDweller(@RequestBody Dweller dweller);

    ResponseEntity<?> editDweller(@RequestBody Dweller dweller, @PathVariable Integer id);

    ResponseEntity<?> deleteDweller(@PathVariable Integer id);
}
