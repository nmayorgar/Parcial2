package com.example.Futbool.Controller;

import com.example.Futbool.Model.Entrenador;
import com.example.Futbool.Services.Entrenador_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@CrossOrigin(origins = "*")
public class Entrenador_Controller {

    @Autowired
    private Entrenador_Service entrenadorService;

    @GetMapping
    public List<Entrenador> listarTodos() {
        return entrenadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtenerPorId(@PathVariable Long id) {
        Entrenador entrenador = entrenadorService.obtenerPorId(id);
        return (entrenador != null) ? ResponseEntity.ok(entrenador) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Entrenador> save(@RequestBody Entrenador entrenador) {
        Entrenador nuevoEntrenador = entrenadorService.guardar(entrenador);
        return ResponseEntity.status(201).body(nuevoEntrenador);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Long id, @RequestBody Entrenador actualizado) {
        Entrenador existente = entrenadorService.obtenerPorId(id);
        if (existente != null) {
            existente.setNombre(actualizado.getNombre());
            return ResponseEntity.ok(entrenadorService.guardar(existente));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/general/{id}")
    public ResponseEntity<Entrenador> actualizar(@PathVariable Long id, @RequestBody Entrenador entrenadorActualizado) {
        Entrenador existente = entrenadorService.obtenerPorId(id);
        if (existente != null) {
            existente.setNombre(entrenadorActualizado.getNombre());
            existente.setEspecialidad(entrenadorActualizado.getEspecialidad());
            existente.setEquipo(entrenadorActualizado.getEquipo());
            return ResponseEntity.ok(entrenadorService.guardar(existente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (entrenadorService.obtenerPorId(id) != null) {
            entrenadorService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
