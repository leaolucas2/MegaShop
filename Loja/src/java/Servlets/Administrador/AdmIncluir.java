/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Administrador;

import DAO.AdmDAO;
import DAO.Administrador;
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
public class AdmIncluir extends HttpServlet {

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
        String nome = request.getParameter("nome");
        try {
            String senha = request.getParameter("senha");
            request.setAttribute("erro_nome", "");

            if ((senha.isEmpty()) || (nome.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (senha.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode ser vazia");
                }

                RequestDispatcher rd = request.getRequestDispatcher("Form_Adm.jsp");
                rd.forward(request, response);
            } else {

                Administrador administrador = new Administrador(nome, senha);
                AdmDAO adm_dao = new AdmDAO();
                try {
                    adm_dao.Inserir(administrador);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "AdmServ");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_senha", "A senha não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Adm.jsp");
            rd.forward(request, response);
        }

    }

}
