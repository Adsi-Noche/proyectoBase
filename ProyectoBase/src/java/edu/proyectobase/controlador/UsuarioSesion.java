package edu.proyectobase.controlador;

import edu.proyectobase.entidades.TipoDocumento;
import edu.proyectobase.entidades.Usuario;
import edu.proyectobase.entidades.UsuarioRol;
import edu.proyectobase.facade.TipoDocumentoFacadeLocal;
import edu.proyectobase.facade.UsuarioFacadeLocal;
import edu.proyectobase.facade.UsuarioRolFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {

    @EJB
    UsuarioRolFacadeLocal usuarioRolFacadeLocal;
    @EJB
    TipoDocumentoFacadeLocal tipoDocumentoFacadeLocal;
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String nombre = "";
    private String nombreUsuario = "";
    private String apellido = "";
    private String clave = "";
    private String correo = "";
    private String documento = "";
    private int tipoDocumento = 0;
    private Usuario usuLogin;

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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<Usuario> leerTodosUsuario() {
        try {
            return usuarioFacadeLocal.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<TipoDocumento> lstTipoDocumento() {

        try {

            return tipoDocumentoFacadeLocal.findAll();

        } catch (Exception e) {

            return null;
        }

    }

    public void actualizarUsuario() {

        try {
            usuarioFacadeLocal.edit(usuLogin);
            PrimeFaces.current().executeScript("estadoOk('" + usuLogin.getUSUNombres() + " " + usuLogin.getUSUApellidos() + "  Datos Actualizados ')");
        } catch (Exception e) {

            PrimeFaces.current().executeScript("estadoBad('Usuario no registrado')");
        }

    }

    public void eliminarUsuario(int idUsuario) {

        try {

            usuarioRolFacadeLocal.removerPermisos(idUsuario);

            usuarioFacadeLocal.removerUsuario(idUsuario);

        } catch (Exception e) {
        }

    }

    public String ingresarUsuario() {
        try {
            TipoDocumento objDocumento = tipoDocumentoFacadeLocal.find(tipoDocumento);

            Usuario usuIn = new Usuario();
            usuIn.setUSUTipoDocumento(objDocumento);

            usuIn.setUSUDocumento(documento);
            usuIn.setUSUApellidos(apellido);
            usuIn.setUSUNombres(nombre);
            usuIn.setUSUCorreoElectronico(correo);
            usuIn.setUSUClave(clave);
            boolean usuarioReg;

            usuarioReg = usuarioFacadeLocal.ingresarUsuario(usuIn);
            if (usuarioReg) {
                int posicion = usuarioFacadeLocal.consultaId(documento);
                boolean resultado = usuarioFacadeLocal.asignarRol(posicion, 3);
                resultado = usuarioFacadeLocal.asignarRol(posicion, 1);

                PrimeFaces.current().executeScript("estadoOk('" + nombre + " " + apellido + "')");
            } else {
                PrimeFaces.current().executeScript("estadoBad('Usuario ya registrado')");
            }

            this.documento = "";
            this.tipoDocumento = 0;
            this.nombre = "";
            this.apellido = "";
            this.correo = "";
            this.clave = "";
        } catch (Exception e) {
            PrimeFaces.current().executeScript("estadoBad('" + tipoDocumento + "  " + apellido + "')");
        }
        return "";
    }

    public String validarUsuario() {
        try {
            this.usuLogin = usuarioFacadeLocal.iniciarSesion(clave, correo);
            String ruta = "#";
            if (usuLogin != null) {
                for (UsuarioRol objRol : usuLogin.getUsuarioRolCollection()) {
                    ruta = objRol.getROLPKRol().getROLNombre();
                    break;
                }

                return "/" + ruta + "/index.xhtml?faces-redirect=true";

            } else {
                PrimeFaces.current().executeScript("estadoBad('Usuario no registrado')");
                return "";
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("estadoBad('Usuario no registrado')");
            return "";

        }
    }

    public List<Usuario> usuarioRegistrados() {

        return usuarioFacadeLocal.filtrarUsuarios(documento,nombre);
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }

    public void cambiarEstado(int id) {

        try {

            Usuario usuCambiarEStado = usuarioFacadeLocal.find(id);

            if (usuCambiarEStado.getUSUEstado().equals("Activo")) {
                usuarioFacadeLocal.cambiarEstadoUsu(id, "Inactivo");
            } else {
                usuarioFacadeLocal.cambiarEstadoUsu(id, "Activo");
            }

        } catch (Exception e) {
        }

    }

}
