package ad.controllers;


import ad.models.DTOs.PrestamoDTO;
import ad.models.Prestamo;
import ad.repositories.InstrumentoRepository;
import ad.services.PrestamoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Devuelve una lista de Prestamo", description = "Devulve una Lista con todos los prestamos registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @GetMapping
    public List<Prestamo> obtenerTodos(){
        return  prestamoService.obtenerTodos();
    }

    @Operation(summary = "Devuelve un prestamo", description = "Devuelve un prestamo seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Prestamo obtenido con exito")
    @GetMapping("/{id}")
    public Prestamo obtenerPorId(@PathVariable int id){
        return prestamoService.obtenerPorId(id);
    }

    @Operation(summary = "Devuelve una lista de prestamos pendientes", description = "Devulve una lista con todos los prestamos pendientes")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @GetMapping("/pendientes")
    public List<Prestamo> obtenerPendientes(){
        return prestamoService.obtenerPendientes();
    }

    @Operation(summary = "Devuelve una lista de prestamos devueltos", description = "Devulve una lista con todos los prestamos devueltos")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @GetMapping("/devueltos")
    public List<Prestamo> obtenerDevueltos() {
        return prestamoService.obtenerDevueltos();
    }

    @Operation(summary = "Guarda un prestamo", description = "Añade un nuevo prestamo al sistema")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @PostMapping
    public Prestamo guardar(@RequestBody PrestamoDTO prestamoDTO) throws Exception {
        return prestamoService.guardar(prestamoDTO);
    }

    @Operation(summary = "Actualiza un prestamo", description = "Actualiza un prestamo seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Prestamo actualizado con exito")
    @PutMapping("/{id}")
    public Prestamo actualizar(@PathVariable int id, @RequestBody PrestamoDTO newPrestamoDTO) throws Exception {
        Prestamo oldPrestamo = obtenerPorId(id);
        newPrestamoDTO.setId(id);

        if (oldPrestamo.getEstado().equals("Pendiente") && newPrestamoDTO.getEstado().equals("Devuelto")){
            newPrestamoDTO.setFecha_devolucion(LocalDate.now());
        } else if (oldPrestamo.getEstado().equals("Devuelto") && newPrestamoDTO.getEstado().equals("Pendiente")) {
            newPrestamoDTO.setFecha_devolucion(null);
        }

        return prestamoService.guardar(newPrestamoDTO);
    }

    @Operation(summary = "Elimina un prestamo", description = "Elimina un prestamo seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Prestamo eliminado con exito")
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        prestamoService.borrar(id);
    }
}
