package ad.services;

import ad.repositories.PrestamoRepository;
import ad.models.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> obtenerTodos(){
        return prestamoRepository.findAll();
    }

    public List<Prestamo> obtenerPendientes(){
        List<Prestamo> listaPendientes = new ArrayList<>();
        prestamoRepository.findAll().forEach(prestamo -> {
            if (prestamo.getEstado().equals("Pendiente")){
                listaPendientes.add(prestamo);
            }
        });
        return listaPendientes;
    }

    public List<Prestamo> obtenerDevueltos(){
        List<Prestamo> listaDeueltos = new ArrayList<>();
        prestamoRepository.findAll().forEach(prestamo -> {
            if (prestamo.getEstado().equals("Devuelto")){
                listaDeueltos.add(prestamo);
            }
        });
        return listaDeueltos;
    }

    public Prestamo obtenerPorId(int id){
        return prestamoRepository.findById(id).orElseGet(null);
    }

    public Prestamo guardar(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }

    public void borrar(int id){
        prestamoRepository.deleteById(id);
    }
}
