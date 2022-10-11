
package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuarios;
import connection.BDConnection;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController implements IUsuarioController {
@Override
public String login (String email_usuario, String password_usuario){ 

    Gson gson=new Gson();
    BDConnection con= new BDConnection();
    String sql ="select * from usuarios where email_usuario = '"+email_usuario+"' and password_usuario= '"+password_usuario+"'";
    
    try {
        Statement st = con.getConnection().createStatement();
        ResultSet rs =st.executeQuery(sql);
        while (rs.next()) {

                int id_usuario = rs.getInt( "id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                int telefono_usuario = rs.getInt("telefono_usuario");
                String direccion_usuario = rs.getString("direccion_usuario");
                int cod_rol = rs.getInt("cod_rol");
                
                Usuarios  usuario =new Usuarios (id_usuario,nombre_usuario ,apellido_usuario, email_usuario,password_usuario, telefono_usuario, direccion_usuario, cod_rol);
                
               return gson.toJson(usuario);
            }
        
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    finally { con.desconectar();}
    
    return "false";
}    
@Override
    public String register(int id_usuario , String nombre_usuario, String apellido_usuario, String email_usuario, String password_usuario, int telefono_usuario, String direccion_usuario, int cod_rol) {

        Gson gson = new Gson();

        BDConnection con = new BDConnection();
        String sql = "Insert into usuarios values('" + id_usuario + "', '" + nombre_usuario + "', '" + apellido_usuario
                + "', '" + email_usuario + "', '" + password_usuario + "', " + telefono_usuario + ",'" + direccion_usuario+ "', " +cod_rol + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuarios usuario = new Usuarios (id_usuario , nombre_usuario,  apellido_usuario,  email_usuario,  password_usuario,  telefono_usuario,  direccion_usuario,  cod_rol);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    
    @Override
    public String pedir(String email_usuario) {

        Gson gson = new Gson();

        BDConnection con = new BDConnection();
        String sql = "Select * from usuarios where email_usuario = '" +email_usuario + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String password_usuario=rs.getString("password_usuario");
                int id_usuario = rs.getInt( "id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                int telefono_usuario = rs.getInt("telefono_usuario");
                String direccion_usuario = rs.getString("direccion_usuario");
                int cod_rol = rs.getInt("cod_rol");
                Usuarios  usuario =new Usuarios (id_usuario,nombre_usuario ,apellido_usuario, email_usuario,password_usuario, telefono_usuario, direccion_usuario,cod_rol);
                               
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
@Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        BDConnection con = new BDConnection();
        String sql = "Select * from usuarios";

       
        List<String> usuarios = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_usuario = rs.getInt( "id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
               String email_usuario = rs.getString("email_usuario");
               String password_usuario=rs.getString("password_usuario");
                int telefono_usuario = rs.getInt("telefono_usuario");
                String direccion_usuario = rs.getString("direccion_usuario");
                int cod_rol = rs.getInt("cod_rol");
                
Usuarios  usuario =new Usuarios (id_usuario,nombre_usuario ,apellido_usuario, email_usuario, password_usuario,telefono_usuario, direccion_usuario,cod_rol);
               

                usuarios.add(gson.toJson(usuario));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(usuarios);

    }
    
    @Override
    public String modificar(String email_usuario, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos,
            int nuevoTelefono, String nuevaDireccion) {

        BDConnection con = new BDConnection();

        String sql = "Update usuarios set password_usuario = '" + nuevaContrasena
                + "', nombre_usuario = '" + nuevoNombre + "', "
                + "apellido_usuario = '" + nuevosApellidos + "', telefono_usuario = '"
                + nuevoTelefono + "', direccion_usuario '" + nuevaDireccion + "'";
        sql += " where email_usuario = '" + email_usuario + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }
    /*@Override
    public String modificar(String email_usuario, String nuevaContrasena_usuario,
            String nuevoNombre_usuario, String nuevoApellido_usuario,
            int nuevoTelefono_usuario,String nuevaDireccion_usuario) {

       BDConnection con = new BDConnection();

        String sql = "Update usuarios set password_usuario= '"+nuevaContrasena_usuario+"', nombre_usuario = '"+nuevoNombre_usuario+"', apellido_usuario = '"+nuevoApellido_usuario+"', telefono_usuario = '"+nuevoTelefono_usuario+"', direccion_usuario = '"+nuevaDireccion_usuario+"'";

           try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String eliminar(String email_usuario) {

        BDConnection con = new BDConnection();

                String sql = "Delete from usuarios where email_usuario = '" + email_usuario + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
     

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }*/


}
