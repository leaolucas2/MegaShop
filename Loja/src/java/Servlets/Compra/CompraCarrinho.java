
package Servlets.Compra;

import DAO.Carrinho;
import DAO.ProdDAO;
import DAO.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Notebook
 */
public class CompraCarrinho extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new Carrinho();
            session.setAttribute("carrinho", carrinho);
        }
        String acao = (String) request.getParameter("acao");
        int id = Integer.parseInt(request.getParameter("id"));
        Produto prod = new Produto(id);
        ProdDAO prod_DAO = new ProdDAO();

        try {
            if (acao.equals("comprar")) {
                carrinho.setCarrinhoItens(prod_DAO.get(prod));
                session.setAttribute("carrinho", carrinho);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else if (acao.equals("remover")) {
                carrinho.removeCarrinhoItens(id);
                session.setAttribute("carrinho", carrinho);
                if(carrinho.getCarrinhoItens().isEmpty()){
                    session.removeAttribute("carrinho");
                }
                RequestDispatcher rd = request.getRequestDispatcher("Carrinho.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
