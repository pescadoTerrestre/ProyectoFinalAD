package ad.models.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Entidad que simplifica al cliente enviar un instrumento")
public class InstrumentoDTO {
    private int id;

    private String nombre;

    private String descripcion;

    private int cantidad;

    private int marca_id;

    private int familia_id;

    public InstrumentoDTO() {
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

    public int getFamilia_id() {
        return familia_id;
    }

    public void setFamilia_id(int familia_id) {
        this.familia_id = familia_id;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }
}
