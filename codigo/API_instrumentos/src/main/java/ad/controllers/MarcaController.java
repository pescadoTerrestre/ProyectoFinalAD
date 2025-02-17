package ad.controllers;

import ad.models.Marca;
import ad.repositories.MarcaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marcas")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @Operation(summary = "Devuelve una lista marcas", description = "Devulve una Lista con todas las marcas registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @GetMapping
    public List<Marca> obtenerTodos(){
        return  marcaRepository.findAll();
    }

    @Operation(summary = "Devuelve una marca", description = "Devuelve una marca seleccionada por Id")
    @ApiResponse(responseCode = "200", description = "Marca obtenida con exito")
    @GetMapping("/{id}")
    public Marca obtenerPorId(@PathVariable int id){
        return marcaRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Guarda una marca")
    @ApiResponse(responseCode = "200", description = "Marca guardada con exito")
    @PostMapping
    public Marca guardar(@RequestBody Marca marca){
        return marcaRepository.save(marca);
    }

    @Operation(summary = "Actualiza una marca", description = "Actualiza una marca seleccionada por Id")
    @ApiResponse(responseCode = "200", description = "Marca actualizada con exito")
    @PutMapping("/{id}")
    public Marca actualizar(@PathVariable int id, @RequestBody Marca marca){
        marca.setId(id);
        return marcaRepository.save(marca);
    }

    @Operation(summary = "Elimina una marca", description = "Elimina una marca seleccionada por Id")
    @ApiResponse(responseCode = "200", description = "Marca eliminada con exito")
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        marcaRepository.deleteById(id);
    }
}
