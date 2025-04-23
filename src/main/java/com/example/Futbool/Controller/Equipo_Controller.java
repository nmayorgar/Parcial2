package com.example.Futbool.Controller;

import com.example.Futbool.Model.Equipo;
import com.example.Futbool.Services.Equipo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*")
public class Equipo_Controller {

    @Autowired
    private Equipo_Service equipoService;

    @GetMapping
    public List<Equipo> listarTodos() {
        return equipoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Long id) {
        return equipoService.obtenerPorId(id);
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoService.guardar(equipo);
    }

    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Long id, @RequestBody Equipo equipoActualizado) {
        return equipoService.actualizar(id, equipoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        equipoService.eliminar(id);
    }
}
