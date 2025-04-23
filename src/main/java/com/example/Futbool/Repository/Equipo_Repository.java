package com.example.Futbool.Repository;

import com.example.Futbool.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Equipo_Repository extends JpaRepository<Equipo, Long> {

    @Query(value = "SELECT * FROM equipo WHERE ciudad = :ciudad", nativeQuery = true)
    List<Equipo> buscarPorCiudad(@Param("ciudad") String ciudad);

    @Query(value = "SELECT COUNT(*) FROM equipo", nativeQuery = true)
    int contarEquipos();
}
