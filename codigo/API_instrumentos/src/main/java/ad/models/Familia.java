package ad.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Entidad que representa una Familia")
@Entity(name = "familias")
public class Familia {
    @Schema(description = "Identificador unico", example = "2")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description = "nombre de la Familia", example = "viento")
    @NotBlank(message = "El nombre nu puede estar en blanco")
    @Column(nullable = false)
    private String nombre;

    @Schema(description = "breve descripcion", example = "Los instrumentos de viento producen sonido haciendo vibrar el aire")
    @Column
    private String descripcion;

    public Familia() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
