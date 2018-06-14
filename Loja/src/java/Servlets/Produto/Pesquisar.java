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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Notebook
 */
public class Pesquisar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        ProdDAO prod_dao = new ProdDAO();
        
        try {
            ArrayList<Produto> produtos = prod_dao.ListarPorNome(nome);
            request.setAttribute("produtos", produtos);

            RequestDispatcher rd = request.getRequestDispatcher("pesquisa.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }
}
