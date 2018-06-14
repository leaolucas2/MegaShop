package Servlets.Produto;

import DAO.ProdDAO;
import DAO.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProdExcluir", urlPatterns = {"/ProdExcluir"})
public class ProdExcluir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = new Produto(id);
        ProdDAO prod_dao = new ProdDAO();
        try {
            prod_dao.get(produto);
            request.setAttribute("produto", produto);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Prod_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Produto produto = new Produto(id);
        try {
            ProdDAO adm_dao = new ProdDAO();
            try {
                adm_dao.Excluir(produto);
                request.setAttribute("mensagem", "Exclusão Com Sucesso");
                request.setAttribute("retorna", "ProdListar");
                RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                rd.forward(request, response);
            }

        } 
        catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }
}
