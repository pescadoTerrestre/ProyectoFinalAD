package ad.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Entidad que representa un instrumento")
@Entity(name = "instrumentos")
public class Instrumento {
    @Schema(description = "Identificador unico", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description = "Nombre del instrumento", example = "Guitarra Acústica")
    @NotBlank(message = "El nombre nu puede estar en blanco")
    @Column
    private String nombre;

    @Schema(description = "Descripcion del instrumentos", example = "Guitarra de 6 cuerdas")
    @Column
    private String descripcion;

    @Schema(description = "Cantidad disponible del instrumento", example = "10")
    @NotBlank(message = "El nombre nu puede estar en blanco")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    @Column
    private int cantidad;

    @Schema(description = "Identificados de la Marca del instrumento", example = "2")
    @ManyToOne
    @JoinColumn(name="marca_id")
    private Marca marca;

    @Schema(description = "Identificador de la Familia a la que pertenece el instrumento", example = "1")
    @ManyToOne
    @JoinColumn(name="familia_id")
    private Familia familia;

    public Instrumento() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
