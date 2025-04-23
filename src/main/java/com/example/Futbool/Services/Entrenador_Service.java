package com.example.Futbool.Services;

import com.example.Futbool.Model.Entrenador;
import com.example.Futbool.Repository.Entrenador_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Entrenador_Service {

    @Autowired
    private Entrenador_Repository entrenadorRepository;

    public List<Entrenador> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    public Entrenador obtenerPorId(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador actualizar(Long id, Entrenador entrenadorActualizado) {
        Optional<Entrenador> entrenadorOptional = entrenadorRepository.findById(id);

        if (entrenadorOptional.isPresent()) {
            Entrenador entrenadorExistente = entrenadorOptional.get();
            entrenadorExistente.setNombre(entrenadorActualizado.getNombre());
            entrenadorExistente.setEspecialidad(entrenadorActualizado.getEspecialidad());
            entrenadorExistente.setEquipo(entrenadorActualizado.getEquipo());
            return entrenadorRepository.save(entrenadorExistente);
        } else {
            return null;
        }
    }

    public void eliminar(Long id) {
        entrenadorRepository.deleteById(id);
    }
}
