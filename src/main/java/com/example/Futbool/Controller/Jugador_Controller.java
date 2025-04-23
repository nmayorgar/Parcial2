package com.example.Futbool.Controller;

import com.example.Futbool.Model.Jugador;
import com.example.Futbool.Services.Jugador_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "*")
public class Jugador_Controller {

    @Autowired
    private Jugador_Service jugador_Service;

    @GetMapping
    public List<Jugador> listarTodos() {
        return jugador_Service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Jugador obtenerPorId(@PathVariable Long id) {
        return jugador_Service.obtenerPorId(id);
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugador_Service.guardar(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable Long id, @RequestBody Jugador jugadorActualizado) {
        return jugador_Service.actualizar(id, jugadorActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        jugador_Service.eliminar(id);
    }
}
