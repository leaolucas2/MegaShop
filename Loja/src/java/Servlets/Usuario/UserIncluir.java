/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Notebook
 */
public class UserIncluir extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        
        try {
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String end = request.getParameter("endereco");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String cep = request.getParameter("cep");
            String uf = request.getParameter("uf");
            String ref = request.getParameter("referencia");
            String tel = request.getParameter("telefone");
            String cel = request.getParameter("celular");
            String cartao = request.getParameter("num_cartao");
            String bandeira = request.getParameter("bandeira");
            request.setAttribute("erro_nome", "");

            if (!nome.isEmpty() || !cpf.isEmpty() || !rg.isEmpty() ) // verifica os dados
            {
                Usuario usuario = new Usuario(nome,cpf,rg,end,bairro,cidade,cep,uf,ref,tel,cel,cartao,bandeira);
                UserDAO user_dao = new UserDAO();
                try {
                    user_dao.Inserir(usuario);
                    request.setAttribute("mensagem", "Cadastro Concluído");
                    request.setAttribute("retorna", "UserListar");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta_1.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            } else {  // retorna para o formulario de contato
                
                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }
                
                if (cpf.isEmpty()) {
                    request.setAttribute("erro_cpf", "A descricao não pode ser vazia");
                }
                
                if (rg.isEmpty()) {
                    request.setAttribute("erro_rg", "O valor não pode ser vazio");
                }
                
                
                
                RequestDispatcher rd = request.getRequestDispatcher("Form_User_1.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_cpf", "A desrição não pode ser vazia");
            request.setAttribute("erro_rg", "O valor não pode ser vazio");
            RequestDispatcher rd = request.getRequestDispatcher("Form_User.jsp");
            rd.forward(request, response);
        }

    }
}
