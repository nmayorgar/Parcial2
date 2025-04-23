package com.example.Futbool.Repository;

import com.example.Futbool.Model.Estadisticas_Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Estadisticas_Repository extends JpaRepository<Estadisticas_Jugador, Long> {

    @Query(value = "SELECT * FROM estadisticas WHERE jugador_id = :jugadorId", nativeQuery = true)
    List<Estadisticas_Jugador> obtenerPorJugador(@Param("jugadorId") Long jugadorId);

    @Query(value = "SELECT AVG(goles) FROM estadisticas", nativeQuery = true)
    Double promedioGoles();
}
