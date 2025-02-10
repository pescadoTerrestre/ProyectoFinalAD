package ad.APIntrumentos.controllers;

import ad.APIntrumentos.repositories.FamilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/familias")
public class FamiliaController {

    @Autowired
    private FamilaRepository familaRepository;


}
