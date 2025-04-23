package com.example.Futbool.Services;

import com.example.Futbool.Model.Estadisticas_Jugador;
import com.example.Futbool.Repository.Estadisticas_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Estadisticas_Service {

    @Autowired
    private Estadisticas_Repository estadisticasRepository;

     public List<Estadisticas_Jugador> obtenerTodas() {
        return estadisticasRepository.findAll();
    }

    public Estadisticas_Jugador obtenerPorId(Long id) {
        return estadisticasRepository.findById(id).orElse(null);
    }

    public Estadisticas_Jugador guardar(Estadisticas_Jugador estadisticas) {
        return estadisticasRepository.save(estadisticas);
    }

    public Estadisticas_Jugador actualizar(Long id, Estadisticas_Jugador estadisticasActualizadas) {
        Optional<Estadisticas_Jugador> estadisticasExistentes = estadisticasRepository.findById(id);

        if (estadisticasExistentes.isPresent()) {
            Estadisticas_Jugador estadisticas = estadisticasExistentes.get();
            estadisticas.setMinutos_juador(estadisticasActualizadas.getMinutos_juador());
            estadisticas.setGoles(estadisticasActualizadas.getGoles());
            estadisticas.setAsistencias(estadisticasActualizadas.getAsistencias());
            estadisticas.setTarjetas_amarillas(estadisticasActualizadas.getTarjetas_amarillas());
            estadisticas.setTarjetas_rojas(estadisticasActualizadas.getTarjetas_rojas());
            estadisticas.setJugador(estadisticasActualizadas.getJugador());
            estadisticas.setPartido(estadisticasActualizadas.getPartido());
            return estadisticasRepository.save(estadisticas);
        } else {
            return null;
        }
    }

    public void eliminar(Long id) {
        estadisticasRepository.deleteById(id);
    }
}
