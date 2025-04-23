package com.example.Futbool.Controller;

import com.example.Futbool.Model.Estadisticas_Jugador;
import com.example.Futbool.Services.Estadisticas_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@CrossOrigin(origins = "*")
public class Estadisticas_Controller {

    @Autowired
    private Estadisticas_Service estadisticasService;

    @GetMapping
    public List<Estadisticas_Jugador> listarTodas() {
        return estadisticasService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Estadisticas_Jugador obtenerPorId(@PathVariable Long id) {
        return estadisticasService.obtenerPorId(id);
    }

    @PostMapping
    public Estadisticas_Jugador crear(@RequestBody Estadisticas_Jugador estadisticas) {
        return estadisticasService.guardar(estadisticas);
    }

    @PutMapping("/{id}")
    public Estadisticas_Jugador actualizar(@PathVariable Long id, @RequestBody Estadisticas_Jugador estadisticasActualizadas) {
        return estadisticasService.actualizar(id, estadisticasActualizadas);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estadisticasService.eliminar(id);
    }
}
