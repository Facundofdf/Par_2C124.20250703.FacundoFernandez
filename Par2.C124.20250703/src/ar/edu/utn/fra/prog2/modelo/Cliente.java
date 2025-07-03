package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;

/**
 *
 * @author Facundo
 */
public class Cliente implements Serializable {

    private String nombre;
    private String email;
    private String contraseña;

    public Cliente(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean validarContrseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }
    
    public boolean validarEmail(String email){
        return this.email.equals(email);
    }
}
