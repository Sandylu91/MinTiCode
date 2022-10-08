package test;

import beans.Usuarios;
import connection.BDConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
listarUsuarios();
    }

    public static void actualizarUsuarios(int id_usuario, String nombre_usuario, String apellido_usuario, String email_usuario, String password_usuario, int telefono_usuario, String direccion_usuario, int cod_rol) {

        BDConnection con = new BDConnection();
        String sql = "Update usuarios set nombre_usuario = '" +nombre_usuario+"'where id_usuario ="+id_usuario;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarUsuarios() {
        BDConnection con = new BDConnection();
        String sql = "Select * from usuarios";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                int id_usuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                String email_usuario = rs.getString("email_usuario");
                String password_usuario = rs.getString("password_usuario");
                int telefono_usuario = rs.getInt("telefono_usuario");
                String direccion_usuario = rs.getString("direccion_usuario");
                int cod_rol = rs.getInt("cod_rol");
                
                Usuarios  usuarios=new Usuarios (id_usuario,nombre_usuario ,apellido_usuario, email_usuario,password_usuario, telefono_usuario, direccion_usuario,
cod_rol);
                
                System.out.println(usuarios.toString());
            }
            st.executeQuery(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

}
