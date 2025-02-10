package ad.APIntrumentos.controllers;

import ad.APIntrumentos.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;
}
