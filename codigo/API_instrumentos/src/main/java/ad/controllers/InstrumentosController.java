package ad.controllers;

import ad.models.DTOs.InstrumentoIdsDTO;
import ad.models.Instrumento;
import ad.services.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/instrumentos")
public class InstrumentosController {

    @Autowired
    private InstrumentoService instrumetosRepository;

    @GetMapping
    public List<Instrumento> obtenerTodos(){
        return  instrumetosRepository.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Instrumento obtenerPorId(@PathVariable int id){
        return instrumetosRepository.obtenerPorId(id);
    }

    @PostMapping
    public Instrumento guardar(@RequestBody InstrumentoIdsDTO instrumentoDTO){
        return instrumetosRepository.guardar(instrumentoDTO);
    }

    @PutMapping("/{id}")
    public Instrumento actualizar(@PathVariable int id, @RequestBody InstrumentoIdsDTO instrumentoDTO){
        instrumentoDTO.setId(id);
        return instrumetosRepository.guardar(instrumentoDTO);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        instrumetosRepository.borrar(id);
    }
}
