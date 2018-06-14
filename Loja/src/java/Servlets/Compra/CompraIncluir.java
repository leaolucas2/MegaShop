/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Compra;

import DAO.Compra;
import DAO.CompraDAO;
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
public class CompraIncluir extends HttpServlet {

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
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        Integer id_usuario = Integer.getInteger(request.getParameter("id_usuario"));
        try {
            Integer id_produto = Integer.getInteger(request.getParameter("id_produto"));
            request.setAttribute("erro_nome", "");

            if ((id_usuario == null) || (id_produto== null)) // verifica os dados
            {  // retorna para o formulario de contato

                if (id_usuario == null) {
                    request.setAttribute("erro_id_usuario", "O nome não pode ser vazio");
                }

                if (id_produto == null) {
                    request.setAttribute("erro_id_produto", "A senha não pode ser vazia");
                }

                RequestDispatcher rd = request.getRequestDispatcher("Form_Compra.jsp");
                rd.forward(request, response);
            } else {

                Compra compra = new Compra(id_usuario, id_produto);
                CompraDAO compra_dao = new CompraDAO();
                try {
                    compra_dao.Inserir(compra);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "Fomr_Compra");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_id_produto", "O nome não pode ser vazio");
            request.setAttribute("erro_id_usuario", "A senha não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compra.jsp");
            rd.forward(request, response);
        }

    }
}
