/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CatIncluir extends HttpServlet {

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
        
        try {
            String descricao = request.getParameter("descricao");
            request.setAttribute("erro_descricao", "");

            if (descricao.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato
                request.setAttribute("erro_descricao", "A descricao não pode ser vazia");
                RequestDispatcher rd = request.getRequestDispatcher("Form_Cat.jsp");
                rd.forward(request, response);
            } else {

                Categoria categoria = new Categoria(descricao);
                CatDAO cat_dao = new CatDAO();
                try {
                    cat_dao.Inserir(categoria);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
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
