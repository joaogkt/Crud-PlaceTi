package org.example.crudplaceti.controller;

import org.example.crudplaceti.exception.ResourceNotFoundException;
import org.example.crudplaceti.models.Marca;
import org.example.crudplaceti.models.Modelo;
import org.example.crudplaceti.repository.MarcaRepository;
import org.example.crudplaceti.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaService.getAllMarcas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable int id) {
        Marca marca = marcaService.getMarcaById(id);
        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public Marca createMarca(@RequestBody Marca marca) {
        try {
            return marcaService.createMarca(marca);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable int id, @RequestBody Marca marcaDetails) {
        try {
            Marca updatedMarca = marcaService.updateMarca(id, marcaDetails);
            return new ResponseEntity<>(updatedMarca, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarca(@PathVariable int id) {
        try{
            Marca marca = marcaService.getMarcaById(id);
            System.out.println(marca);
            if (marca == null){
                return ResponseEntity.notFound().build();
            }
            else {
                marcaService.deleteMarca(id);
                return ResponseEntity.ok("Marca delete successfully.");
            }

        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (ResponseStatusException e) {
            if (e.getMessage().contains("Marca not found")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Marca not found.");
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
