package br.com.animal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.animal.beans.Animal;
import br.com.animal.dao.AnimalDAO;

/**
 * Servlet implementation class Registra
 */
@WebServlet("/registra")
public class Registra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registra() {
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
		String especieAnimal = request.getParameter("especieAnimal");
		String nomeAnimal = request.getParameter("nomeAnimal");
		String peso = request.getParameter("peso");
		
		Animal animal = new Animal();
		animal.setEspecieAnimal(especieAnimal);
		animal.setNomeAnimal(nomeAnimal);
		animal.setPeso(Integer.parseInt(peso));
		
		if(AnimalDAO.gravar(animal)) {
			request.setAttribute("message", "Inserido com sucesso, se precisar cadastrar"
				+ " mais um animal, preencha os dados abaixo: <br>"
				+ "<a href=index.jsp>Clique para voltar para a index</a>");
		} else {
			request.setAttribute("message", "Problema na inserção.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar.jsp");
		dispatcher.forward(request, response);
	}

}
