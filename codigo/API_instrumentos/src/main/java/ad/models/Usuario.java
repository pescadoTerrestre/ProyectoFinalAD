package ad.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Schema(description = "Entidad que representa un usuario")
@Entity(name = "usuarios")
public class Usuario {
    @Schema(description = "Identificador unico", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description = "nombre de usuario", example = "Juan Perez")
    @Column
    @NotBlank(message = "El nombre nu puede estar en blanco")
    private String nombre;

    @Schema(description = "dni del usuario", example = "123456789A")
    @Column
    private String dni;

    @Schema(description = "direccion de correo del usuario", example = "juan.perez@example.com")
    @Column
    private String email;

    @Schema(description = "telefono del usuario", example = "555-1234")
    @Column
    private String telefono;

    @Schema(description = "direccion del usuario", example = "Calle Falsa 123")
    @Column
    private String direccion;

    @Schema(description = "fecha en la que el usuario de registra en el sistema", example = "2024-02-17")
    @Column
    private LocalDate fecha_registro;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
