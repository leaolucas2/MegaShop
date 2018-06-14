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
public class AdmEditar extends HttpServlet {
    
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Administrador administrador = new Administrador(id);
        AdmDAO adm_dao = new AdmDAO();
        try {
            adm_dao.get(administrador);
            request.setAttribute("administrador", administrador);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Adm_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String senha = request.getParameter("senha");
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");

        Administrador administrador = new Administrador(id, nome, senha);
        try {
            if ((senha.isEmpty()) || (nome.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (senha.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode estar vazia");
                }


                request.setAttribute("administrador", administrador);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Adm_Editar.jsp");
                rd.forward(request, response);
            } else {

                AdmDAO adm_dao = new AdmDAO();
                try {
                    adm_dao.Alterar(administrador);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
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
