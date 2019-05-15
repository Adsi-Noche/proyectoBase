package edu.proyectobase.controlador;

import edu.proyectobase.modelo.Rol;
import edu.proyectobase.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {

    private String nombre = "";
    private String apellido = "";
    private String usuario = "";
    private String clave = "";
    private String correo = "";
    private List<Usuario> usuarioRegistrados = new ArrayList<>();

    public UsuarioSesion() {

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

    public List<Usuario> getUsuarioRegistrados() {
        return usuarioRegistrados;
    }

    public void setusuarioRegistrados(List<Usuario> usuarioRegistrados) {
        this.usuarioRegistrados = usuarioRegistrados;
    }

    public boolean ValidarNombreUsuario() {
        for (Usuario obj : usuarioRegistrados) {
            if (obj.getUsuario().equals(usuario)) {
                return false;
            }
        }
        return true;
    }

    public String validarUsuario() {
        for (Usuario obj : usuarioRegistrados) {
            if (obj.getUsuario().equals(usuario) && obj.getClave().equals(clave)) {
                return "Administrador/index.xhtml?faces-redirect=true";
            }
        }

        FacesMessage inforMessagge = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario no existe", "!");
        FacesContext.getCurrentInstance().addMessage("mensajeNoExisteUser", inforMessagge);

        return "";
    }

    public void adicionarUsuario() {
        if (ValidarNombreUsuario()) {
            List<Rol> listaMisRoles = new ArrayList<>();
            Rol roles = new Rol("Adrministrador", "Todos los permisos");
            listaMisRoles.add(roles);
            Usuario usulog = new Usuario(nombre, apellido, usuario, clave, correo, listaMisRoles);
            usuarioRegistrados.add(usulog);
            LimpiarFormulario();
            FacesMessage inforMessagge = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario registrado", "satisfactoriamente");
            FacesContext.getCurrentInstance().addMessage("mensajeRegistro", inforMessagge);
        } else {
            FacesMessage inforMessagge = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario ya existente", "!!");
            FacesContext.getCurrentInstance().addMessage("mensajeRegistro", inforMessagge);
        }

    }

    public void LimpiarFormulario() {
        this.nombre = "";
        this.apellido = "";
        this.usuario = "";
        this.clave = "";
        this.correo = "";
    }

}
