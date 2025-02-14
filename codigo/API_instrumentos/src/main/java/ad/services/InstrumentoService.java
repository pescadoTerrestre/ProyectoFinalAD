package ad.services;

import ad.models.DTOs.InstrumentoIdsDTO;
import ad.models.Instrumento;
import ad.repositories.FamiliaRepository;
import ad.repositories.InstrumentoRepository;
import ad.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentoService {
    @Autowired
    private InstrumentoRepository instrumentoReposotory;

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Instrumento> obtenerTodos(){
        return instrumentoReposotory.findAll();
    }

    public Instrumento obtenerPorId(int id){
        return instrumentoReposotory.findById(id).orElseGet(null);
    }

    public Instrumento guardar(InstrumentoIdsDTO instrumentoDTO){
        Instrumento instrumento = new Instrumento();

        instrumento.setId(instrumentoDTO.getId());
        instrumento.setNombre(instrumentoDTO.getNombre());
        instrumento.setCantidad(instrumentoDTO.getCantidad());
        instrumento.setDescripcion(instrumentoDTO.getDescripcion());
        instrumento.setFamilia(familiaRepository.findById(instrumentoDTO.getFamilia_id()).orElse(null));
        instrumento.setMarca(marcaRepository.findById(instrumentoDTO.getMarca_id()).orElse(null));

        return instrumentoReposotory.save(instrumento);
    }

    public void borrar(int id){
        instrumentoReposotory.deleteById(id);
    }
}
