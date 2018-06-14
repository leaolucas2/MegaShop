package Servlets.Usuario;

import DAO.UserDAO;
import DAO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserVisualizar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = new Usuario(id);
        UserDAO user_dao = new UserDAO();
        try {
            user_dao.get(usuario);
            request.setAttribute("usuario", usuario);

            RequestDispatcher rd = request.getRequestDispatcher("Form_User_Visualizar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }
}
