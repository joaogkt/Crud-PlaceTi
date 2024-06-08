package org.example.crudplaceti.services;

import org.example.crudplaceti.models.Marca;
import org.example.crudplaceti.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca getMarcaById(int id){
        return marcaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca not found"));
    }

    public Marca createMarca(Marca marca){
        return marcaRepository.save(marca);
    }
    public List<Marca> getAllMarcas(){
        return marcaRepository.findAll();
    }
    public Marca updateMarca(int id, Marca marcadetails){
        Marca marca = getMarcaById(id);
        marca.setNome(marcadetails.getNome());
        marca.setCodigoDenatran(marcadetails.getCodigoDenatran());
        marca.setAtivo(marcadetails.isAtivo());
        return marcaRepository.save(marca);
    }
    public void deleteMarca(int id){
        marcaRepository.deleteById(id);
    }
}
