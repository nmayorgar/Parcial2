package com.example.Futbool.Repository;

import com.example.Futbool.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Jugador_Repository extends JpaRepository<Jugador, Long> {

    @Query(value = "SELECT * FROM jugador WHERE posicion = :posicion", nativeQuery = true)
    List<Jugador> buscarPorPosicion(@Param("posicion") String posicion);

    @Query(value = "SELECT * FROM jugador WHERE equipo_id = :equipoId", nativeQuery = true)
    List<Jugador> buscarPorEquipo(@Param("equipoId") Long equipoId);
}
