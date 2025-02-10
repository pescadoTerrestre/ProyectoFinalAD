package ad.APIntrumentos.controllers;

import ad.APIntrumentos.repositories.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/instrumentos")
public class InstrumentoController {

    @Autowired
    private InstrumentoRepository instrumentoRepository;
}
