package com.example.Futbool.Services;

import com.example.Futbool.Model.Equipo;
import com.example.Futbool.Repository.Equipo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Equipo_Service {

    @Autowired
    private Equipo_Repository equipoRepository;

    // Obtener todos los equipos
    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    // Obtener un equipo por su ID
    public Equipo obtenerPorId(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    // Guardar un nuevo equipo
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    // Actualizar un equipo existente
    public Equipo actualizar(Long id, Equipo equipoActualizado) {
        Optional<Equipo> equipoExistente = equipoRepository.findById(id);

        if (equipoExistente.isPresent()) {
            Equipo equipo = equipoExistente.get();
            equipo.setNombre(equipoActualizado.getNombre());
            equipo.setCiudad(equipoActualizado.getCiudad());
            equipo.setFundacion(equipoActualizado.getFundacion());
            return equipoRepository.save(equipo);
        } else {
            return null; // Si no se encuentra el equipo con el ID
        }
    }

    // Eliminar un equipo por ID
    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }
}
