package ad.APIntrumentos.controllers;

import ad.APIntrumentos.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;
}
