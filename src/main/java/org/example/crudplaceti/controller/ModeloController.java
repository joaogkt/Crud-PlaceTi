package org.example.crudplaceti.controller;

import org.example.crudplaceti.exception.ResourceNotFoundException;
import org.example.crudplaceti.models.Marca;
import org.example.crudplaceti.models.Modelo;
import org.example.crudplaceti.repository.ModeloRepository;
import org.example.crudplaceti.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<Modelo> getAllModelos() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModeloById(@PathVariable int id) {
        Modelo modelo = modeloService.getModeloById(id);
        if (modelo != null) {
            return ResponseEntity.ok(modelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Modelo createModelo(@RequestBody Modelo modelo) {
        try {
            return modeloService.createModelo(modelo);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(@PathVariable int id, @RequestBody Modelo modeloDetails) {
        try {
            Modelo modelo = modeloService.getModeloById(id);
            modelo.setMarca(modeloDetails.getMarca());
            modelo.setNome(modeloDetails.getNome());
            modelo.setAno(modeloDetails.getAno());
            modelo.setAtivo(modeloDetails.isAtivo());
            Modelo updatedModelo = modeloService.updateModelo(id, modelo);
            return new ResponseEntity<>(updatedModelo, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marca> deleteModelo(@PathVariable int id) {
        try{
            modeloService.deleteModelo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (ResponseStatusException e) {
            if (e.getMessage().contains("Modelo not found")){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
