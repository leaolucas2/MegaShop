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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Notebook
 */
public class ProdIncluir extends HttpServlet {
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        
        try {
            Integer id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String valor = request.getParameter("valor");
            //request.setAttribute("erro_nome", "");

            if (nome.isEmpty() || descricao.isEmpty() || valor.isEmpty() ) // verifica os dados
            {
                Float valorf = Float.parseFloat(valor);
                Produto produto = new Produto(id_categoria,nome,descricao,valorf);
                ProdDAO prod_dao = new ProdDAO();
                try {
                    prod_dao.Inserir(produto);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ProdListar");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            } else {  // retorna para o formulario de contato
                
                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }
                
                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descricao", "A descricao não pode ser vazia");
                }
                
                if (valor.isEmpty()) {
                    request.setAttribute("erro_valor", "O valor não pode ser vazio");
                }
                
                
                
                RequestDispatcher rd = request.getRequestDispatcher("Form_Prod.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_descricao", "A desrição não pode ser vazia");
            request.setAttribute("erro_valor", "O valor não pode ser vazio");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Prod.jsp");
            rd.forward(request, response);
        }

    }
}
