package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet("/ServletUsuarioRegister")
public class ServletUsuarioRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioController usuario = new UsuarioController();

        int id_usuario = Integer.parseInt( request.getParameter("id_usuario"));
        String nombre_usuario = request.getParameter("nombre_usuario");
        String apellido_usuario = request.getParameter("apellido_usuario");
        String email_usuario = request.getParameter("email_usuario");
        String password_usuario = request.getParameter("password_usuario");
        int telefono_usuario =Integer.parseInt( request.getParameter("telefono_usuario"));
        String direccion_usuario = request.getParameter("direccion_usuario");
       int cod_rol =Integer.parseInt( request.getParameter("cod_rol"));

        String result = usuario.register (id_usuario,nombre_usuario,apellido_usuario,email_usuario,password_usuario,telefono_usuario,direccion_usuario,cod_rol);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
    }

}
