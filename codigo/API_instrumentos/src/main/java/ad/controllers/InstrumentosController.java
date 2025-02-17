package ad.controllers;

import ad.models.DTOs.InstrumentoDTO;
import ad.models.Instrumento;
import ad.services.InstrumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/instrumentos")
public class InstrumentosController {

    @Autowired
    private InstrumentoService instrumetosRepository;

    @Operation(summary = "Devuelve una lista de instrumentos", description = "Devulve una Lista con todos los instrumentos registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @GetMapping
    public List<Instrumento> obtenerTodos(){
        return  instrumetosRepository.obtenerTodos();
    }

    @Operation(summary = "Devuelve un instrumento", description = "Devuelve un instrumento seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Instrumento obtenido con exito")
    @GetMapping("/{id}")
    public Instrumento obtenerPorId(@PathVariable int id){
        return instrumetosRepository.obtenerPorId(id);
    }

    @Operation(summary = "Guarda un instrumento", description = "Añade un nuevo instrumento al sistema")
    @ApiResponse(responseCode = "200", description = "Instrumento guardado con exito")
    @PostMapping
    public Instrumento guardar(@RequestBody InstrumentoDTO instrumentoDTO){
        return instrumetosRepository.guardar(instrumentoDTO);
    }

    @Operation(summary = "Actualiza un instrumento", description = "Actualiza un instrumento seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Instrumento actualizado con exito")
    @PutMapping("/{id}")
    public Instrumento actualizar(@PathVariable int id, @RequestBody InstrumentoDTO instrumentoDTO){
        instrumentoDTO.setId(id);
        return instrumetosRepository.guardar(instrumentoDTO);
    }

    @Operation(summary = "Elimina un instrumento", description = "Elimina un instrumento seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Instrumento eliminado con exito")
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        instrumetosRepository.borrar(id);
    }
}
