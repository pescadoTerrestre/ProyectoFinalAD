package ad.APIntrumentos.models;

import jakarta.persistence.*;

@Entity(name = "marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String pais_origen;
}
