package ad.controllers;


import ad.models.DTOs.PrestamoIdsDTO;
import ad.models.Instrumento;
import ad.models.Prestamo;
import ad.repositories.InstrumentoRepository;
import ad.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;
    @Autowired
    private InstrumentoRepository instrumentoRepository;

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
    public Prestamo guardar(@RequestBody PrestamoIdsDTO prestamoDTO) throws Exception {

        return prestamoService.guardar(prestamoDTO);
    }

    @PutMapping("/{id}")
    public Prestamo actualizar(@PathVariable int id, @RequestBody PrestamoIdsDTO newPrestamoDTO) throws Exception {
        Prestamo oldPrestamo = obtenerPorId(id);
        newPrestamoDTO.setId(id);

        if (oldPrestamo.getEstado().equals("Pendiente") && newPrestamoDTO.getEstado().equals("Devuelto")){
            newPrestamoDTO.setFecha_devolucion(LocalDate.now());
        } else if (oldPrestamo.getEstado().equals("Devuelto") && newPrestamoDTO.getEstado().equals("Pendiente")) {
            newPrestamoDTO.setFecha_devolucion(null);
        }

        return prestamoService.guardar(newPrestamoDTO);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        prestamoService.borrar(id);
    }
}
