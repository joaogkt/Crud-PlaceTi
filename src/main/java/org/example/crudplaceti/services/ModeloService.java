package org.example.crudplaceti.services;

import org.example.crudplaceti.exception.ResourceNotFoundException;
import org.example.crudplaceti.models.Modelo;
import org.example.crudplaceti.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public Modelo getModeloById(int id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo nao encontrado para esse id: " + id));

    }
    public List<Modelo> getAllModelos() {
        return modeloRepository.findAll();
    }
    public Modelo createModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo updateModelo(int id, Modelo modeloDetails) {
        Modelo modelo = getModeloById(id);

        modelo.setNome(modeloDetails.getNome());
        modelo.setAno(modeloDetails.getAno());
        modelo.setAtivo(modeloDetails.isAtivo());
        return modeloRepository.save(modelo);
    }
    public void deleteModelo(int id) {
        modeloRepository.deleteById(id);
    }
}
