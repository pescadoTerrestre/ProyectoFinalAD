package ad.controllers;

import ad.models.Familia;
import ad.repositories.FamiliaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/familias")
public class FamiliaController {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Operation(summary = "Devuelve una lista de clase familia", description = "Devulve una Lista con todos los elementos familia registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @GetMapping
    public List<Familia> obtenerTodos(){
        return  familiaRepository.findAll();
    }

    @Operation(summary = "Devuelve un elemento famila", description = "Devuelve un elemento famila seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Objeto famila obtenido con exito")
    @GetMapping("/{id}")
    public Familia obtenerPorId(@PathVariable int id){
        return familiaRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Guarda un elemento famila", description = "Añade un elemento familia al sistema")
    @ApiResponse(responseCode = "200", description = "Objeto famila guardado con exito")
    @PostMapping
    public Familia guardar(@RequestBody Familia familia){
        return familiaRepository.save(familia);
    }

    @Operation(summary = "Actualiza un elemento famila", description = "Actualiza un elemento famila seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Objeto famila actualizado con exito")
    @PutMapping("/{id}")
    public Familia actualizar(@PathVariable int id, @RequestBody Familia familia){
        familia.setId(id);
        return familiaRepository.save(familia);
    }

    @Operation(summary = "Elimina un elemento famila", description = "Elimina un elemento famila seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Objeto famila eliminado con exito")
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        familiaRepository.deleteById(id);
    }
}