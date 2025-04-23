package com.example.Futbool.Controller;

import com.example.Futbool.Model.Partido;
import com.example.Futbool.Services.Partido_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = "*")
public class Partido_Controller {

    @Autowired
    private Partido_Service partidoService;

    @GetMapping
    public List<Partido> listarTodos() {
        return partidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Partido obtenerPorId(@PathVariable Long id) {
        return partidoService.obtenerPorId(id);
    }

    @PostMapping
    public Partido crear(@RequestBody Partido partido) {
        return partidoService.guardar(partido);
    }

    @PutMapping("/{id}")
    public Partido actualizar(@PathVariable Long id, @RequestBody Partido partidoActualizado) {
        return partidoService.actualizar(id, partidoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        partidoService.eliminar(id);
    }
}
