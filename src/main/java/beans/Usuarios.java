
package beans;



public class Usuarios {
    private int id_usuario;
private String nombre_usuario;
    private String apellido_usuario;
    private String email_usuario;
    private String password_usuario;
    private int telefono_usuario;
    private String direccion_usuario;
    private int cod_rol;

    public Usuarios(int id_usuario, String nombre_usuario, String apellido_usuario, String email_usuario, String password_usuario, int telefono_usuario, String direccion_usuario, int cod_rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email_usuario = email_usuario;
        this.password_usuario = password_usuario;
        this.telefono_usuario = telefono_usuario;
        this.direccion_usuario = direccion_usuario;
        this.cod_rol = cod_rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public int getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(int telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public int getCod_rol() {
        return cod_rol;
    }

    public void setCod_rol(int cod_rol) {
        this.cod_rol = cod_rol;
    }

    @Override
    public String toString() {
        return "usuarios{" + "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", email_usuario=" + email_usuario + ", password_usuario=" + password_usuario + ", telefono_usuario=" + telefono_usuario + ", direccion_usuario=" + direccion_usuario + ", cod_rol=" + cod_rol + '}';
    }
    
    
}
