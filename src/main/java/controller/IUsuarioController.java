
package controller;

        import java.util.Map;
public interface IUsuarioController {
    
    public String login (String email_usuario, String password_usuario);
    
   public String register (int id_usuario, String nombre_usuario, String apellido_usuario, String email_usuario, String password_usuario,int telefono_usuario,String direccion_usuario,int cod_rol);
   
   public String pedir(String email_usuario);
   
   public String listar(boolean ordenar, String orden);
   public String modificar(String email_usuario, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos,
            int nuevoTelefono, String nuevaDireccion);
   
/*   
   public String eliminar(String email_usuario);*/
}

