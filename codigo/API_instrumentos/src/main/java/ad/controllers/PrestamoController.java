package ad.controllers;


import ad.models.Prestamo;
import ad.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> obtenerTodos(){
        return  prestamoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Prestamo obtenerPorId(@PathVariable int id){
        return prestamoService.obtenerPorId(id);
    }

    @GetMapping("/pendientes")
    public List<Prestamo> obtenerPendientes(){
        return prestamoService.obtenerPendientes();
    }

    @GetMapping("/devueltos")
    public List<Prestamo> obtenerDevueltos() {
        return prestamoService.obtenerDevueltos();
    }

    @PostMapping
    public Prestamo guardar(@RequestBody Prestamo prestamo){
        return prestamoService.guardar(prestamo);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        prestamoService.borrar(id);
    }
}
