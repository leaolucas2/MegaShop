/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import DAO.AdmDAO;
import DAO.Administrador;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Notebook
 */
@WebFilter(filterName = "Filtro", servletNames={"AdmServ"}, urlPatterns = {"/ListaAdmView.jsp"})
public class Filtro implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public Filtro() {
    }    
    
   @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        RequestDispatcher rd;
        Object logado = session.getAttribute("logado");
        if (logado != null) {
            String estado = (String) logado;
            if (estado.equals("logado")) {
                chain.doFilter(request, response);
            }
        } else {
            try {
                String login = request.getParameter("nome");
                String senha = request.getParameter("senha");

                AdmDAO adm_dao = new AdmDAO();
                Administrador administrador = adm_dao.Login(login);
                if (administrador != null) {
                    if (administrador.getNome().equals(login) && administrador.getSenha().equals(senha)) {
                        session.setAttribute("logado", "logado");
                        session.setAttribute("adm", "nome");
                        chain.doFilter(request, response);

                    } else {
                        request.setAttribute("erro_login", "Usuario e/ou Senha Incorretos");
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                } else if (login != null) {
                    request.setAttribute("erro_login", "Usuario e/ou Senha Incorretos");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else if (login == null) {
                    request.setAttribute("erro_login", "Efetue o Login");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }

            } catch (Exception e) {
                request.setAttribute("erro", "filtro");
                rd = request.getRequestDispatcher("Erro.jsp");
                rd.forward(request, response);

            }
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }
}
