package Servlets.Categoria;

import DAO.CatDAO;
import DAO.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Notebook
 */
public class CatEditar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
          @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria = new Categoria(id);
        CatDAO cat_dao = new CatDAO();
        try {
            cat_dao.get(categoria);
            request.setAttribute("categoria", categoria);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Cat_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String descricao = request.getParameter("descricao");
        int id = Integer.parseInt(request.getParameter("id"));

        Categoria categoria = new Categoria(id, descricao);
        try {
            if (descricao.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                request.setAttribute("erro_descricao", "A descricao não pode estar vazia");
                


                request.setAttribute("descricao", descricao);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Cat_Editar.jsp");
                rd.forward(request, response);
            } else {

                CatDAO cat_dao = new CatDAO();
                try {
                    cat_dao.Alterar(categoria);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "CatListar");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descricao", "A descrição não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Cat.jsp");
            rd.forward(request, response);
        }

    }

}
