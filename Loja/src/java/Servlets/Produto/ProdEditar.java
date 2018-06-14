/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Notebook
 */
@WebServlet(name = "ProdEditar", urlPatterns = {"/ProdEditar"})
public class ProdEditar extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = new Produto(id);
        ProdDAO prod_dao = new ProdDAO();
        try {
            prod_dao.get(produto);
            request.setAttribute("produto", produto);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Prod_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        float valor = Float.parseFloat(request.getParameter("valor"));

        Produto produto = new Produto(id, id_categoria, nome, descricao,valor);
        try {
            if ((descricao.isEmpty()) || (nome.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (nome.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode estar vazia");
                }


                request.setAttribute("produto", produto);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Prod_Editar.jsp");
                rd.forward(request, response);
            } else {

                ProdDAO prod_dao = new ProdDAO();
                try {
                    prod_dao.Alterar(produto);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ProdListar");
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
            RequestDispatcher rd = request.getRequestDispatcher("Form_Prod.jsp");
            rd.forward(request, response);
        }

    }

}
