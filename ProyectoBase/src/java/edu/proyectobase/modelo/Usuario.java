package edu.proyectobase.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre = "";
    private String apellido = "";
    private String usuario = "";
    private String clave = "";
    private String correo = "";
    private List<Rol> rolesUsuario = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String usuario, String clave, String correo, List<Rol> rolesUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.correo = correo;
        this.rolesUsuario.addAll(rolesUsuario);
    }

    public List<Rol> getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(List<Rol> rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
