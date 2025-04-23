package com.example.Futbool.Services;

import com.example.Futbool.Model.Partido;
import com.example.Futbool.Repository.Partido_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Partido_Service {

    @Autowired
    private Partido_Repository partidoRepository;

    public List<Partido> obtenerTodos() {
        return partidoRepository.findAll();
    }

    public Partido obtenerPorId(Long id) {
        return partidoRepository.findById(id).orElse(null);
    }

    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido actualizar(Long id, Partido partidoActualizado) {
        Optional<Partido> partidoExistente = partidoRepository.findById(id);

        if (partidoExistente.isPresent()) {
            Partido partido = partidoExistente.get();
            partido.setFecha(partidoActualizado.getFecha());
            partido.setEstadio(partidoActualizado.getEstadio());
            partido.setEquipoLocal(partidoActualizado.getEquipoLocal());
            partido.setEquipoVisitante(partidoActualizado.getEquipoVisitante());
            partido.setGoles_local(partidoActualizado.getGoles_local());
            partido.setGoles_visita(partidoActualizado.getGoles_visita());
            return partidoRepository.save(partido);
        } else {
            return null;
        }
    }

    public void eliminar(Long id) {
        partidoRepository.deleteById(id);
    }
}
