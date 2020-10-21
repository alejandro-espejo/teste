package br.com.animal.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.animal.beans.Animal;
import br.com.animal.conexao.ConexaoFactory;

/**
 * Servlet implementation class Seleciona
 */
@WebServlet("/seleciona")
public class Seleciona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seleciona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int identificacao = Integer.parseInt(request.getParameter("identificacao"));
		try {
			Connection conexao = (Connection) new ConexaoFactory().getConnection();
			Animal animal = new Animal();
			PreparedStatement estrutura = conexao.prepareStatement("SELECT identificacao, especieAnimal, nomeAnimal, peso FROM animal WHERE identificacao = ?");
			estrutura.setInt(1, identificacao);
			ResultSet resultadoDados = estrutura.executeQuery();
			if(resultadoDados.next()) {
				animal.setIdentificacao(resultadoDados.getInt("identificacao"));
				animal.setEspecieAnimal(resultadoDados.getString("especieAnimal"));
				animal.setNomeAnimal(resultadoDados.getString("nomeAnimal"));
				animal.setPeso(resultadoDados.getInt("peso"));
				request.setAttribute("message", "<h1>Retorno da seleção</h1>"
						+ "<table border=1> <tr> <td>Identificação</td> <td>Nome</td> "
						+ "<td>Login</td> <td>Senha</td></tr>"
						+ "<tr> <td>" + animal.getIdentificacao() + "</td>"
						+ "<td>" + animal.getEspecieAnimal() + "</td>"
						+ "<td>" + animal.getNomeAnimal() + "</td>"
						+ "<td>" + animal.getPeso() + "</td>"
						+ " </tr> </table>" );
			}	
			resultadoDados.close();
			estrutura.close();
		} catch (SQLException e) {
			System.out.print("Erro: ");
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("selecionar.jsp");
		dispatcher.forward(request, response);
	}

}
