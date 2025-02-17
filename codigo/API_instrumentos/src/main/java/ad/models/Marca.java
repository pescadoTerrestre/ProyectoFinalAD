package ad.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Entidad que representa una Marca")
@Entity(name = "marcas")
public class Marca {
    @Schema(description = "Identificador unico", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description = "Nombre de la marca", example = "Yamaha")
    @NotBlank(message = "El nombre nu puede estar bacio")
    @Column(nullable = false)
    private String nombre;

    @Schema(description = "pais de la marca", example = "Japon")
    @Column
    private String pais_origen;

    public Marca() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }
}
