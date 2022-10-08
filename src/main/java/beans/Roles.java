
package beans;

public class Roles {

private int cod_rol;
private String rol;

    public Roles(int cod_rol, String rol) {
        this.cod_rol = cod_rol;
        this.rol = rol;
    }

    public int getCod_rol() {
        return cod_rol;
    }

    public void setCod_rol(int cod_rol) {
        this.cod_rol = cod_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "roles{" + "cod_rol=" + cod_rol + ", rol=" + rol + '}';
    }


}
