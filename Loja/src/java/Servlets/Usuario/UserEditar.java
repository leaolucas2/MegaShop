
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
public class UserEditar extends HttpServlet {

    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = new Usuario(id);
        UserDAO user_dao = new UserDAO();
        try {
            user_dao.get(usuario);
            request.setAttribute("usuario", usuario);

            RequestDispatcher rd = request.getRequestDispatcher("Form_User_Editar.jsp");
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
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String cep = request.getParameter("cep");
        String uf = request.getParameter("uf");
        String referencia = request.getParameter("referencia");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String num_cartao = request.getParameter("num_cartao");
        String bandeira = request.getParameter("bandeira");

        Usuario usuario = new Usuario(id,nome,cpf,rg,endereco,bairro,cidade,cep,uf,referencia,telefone,celular,num_cartao,bandeira);
        try {
            if ((cpf.isEmpty()) || (nome.isEmpty())|| (rg.isEmpty()) || (endereco.isEmpty()) || (bairro.isEmpty()) || (cidade.isEmpty()) || (cep.isEmpty()) || (uf.isEmpty()) || (referencia.isEmpty()) || (telefone.isEmpty()) || (celular.isEmpty()) || (num_cartao.isEmpty()) || (bandeira.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (cpf.isEmpty()) {
                    request.setAttribute("erro_cpf", "O nome não pode ser vazio");
                }

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "A senha não pode estar vazia");
                }
                
                if (rg.isEmpty()) {
                    request.setAttribute("erro_rg", "A senha não pode estar vazia");
                }
                
                if ((endereco.isEmpty()) || (bairro.isEmpty()) || (cidade.isEmpty()) || (cep.isEmpty()) || (uf.isEmpty()) || (referencia.isEmpty()) || (telefone.isEmpty()) || (celular.isEmpty()) || (num_cartao.isEmpty()) || (bandeira.isEmpty())) {
                    request.setAttribute("erro_dados", "A senha não pode estar vazia");
                }

                request.setAttribute("usuario", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("Form_User_Editar.jsp");
                rd.forward(request, response);
            } else {

                UserDAO user_dao = new UserDAO();
                try {
                    user_dao.Alterar(usuario);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "UserListar");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_cpf", "A senha não pode ser vazia");
            request.setAttribute("erro_rg", "A senha não pode ser vazia");
            request.setAttribute("erro_dados", "A dados não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_User_Editar.jsp");
            rd.forward(request, response);
        }

    }
}
