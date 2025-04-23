package com.example.Futbool.Services;

import com.example.Futbool.Model.Jugador;
import com.example.Futbool.Repository.Jugador_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Jugador_Service {

    @Autowired
    private Jugador_Repository jugadorRepository;

    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    public Jugador obtenerPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador actualizar(Long id, Jugador jugadorActualizado) {
        Optional<Jugador> jugadorExistente = jugadorRepository.findById(id);

        if (jugadorExistente.isPresent()) {
            Jugador jugador = jugadorExistente.get();
            jugador.setNombre(jugadorActualizado.getNombre());
            jugador.setPosicion(jugadorActualizado.getPosicion());
            jugador.setDorsal(jugadorActualizado.getDorsal());
            jugador.setFecha_nac(jugadorActualizado.getFecha_nac());
            jugador.setNacionalidad(jugadorActualizado.getNacionalidad());
            jugador.setEquipo(jugadorActualizado.getEquipo());
            return jugadorRepository.save(jugador);
        } else {
            return null;
        }
    }

    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }
}
