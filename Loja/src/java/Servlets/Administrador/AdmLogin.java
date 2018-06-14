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
public class AdmLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha"); 
        AdmDAO adm_dao = new AdmDAO();
        try {
            Administrador administrador = adm_dao.Login(nome);
            if ((senha.isEmpty()) || (nome.isEmpty()) || (administrador.getNome()== null)) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (senha.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode estar vazia");
                }
                
                if(administrador.getNome()== null){
                    request.setAttribute("erro_nome", "Este Login não Existe");
                }
            }
            else{
                request.setAttribute("administrador", administrador);
                RequestDispatcher rd = request.getRequestDispatcher("AreaRestrita.jsp");
                rd.forward(request, response);
            }
            
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }
}
