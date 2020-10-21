package br.com.animal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.animal.dao.AnimalDAO;

/**
 * Servlet implementation class Deleta
 */
@WebServlet("/deleta")
public class Deleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleta() {
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
		
		if(AnimalDAO.deletar(identificacao)) {
			request.setAttribute("message", "O registro " +
					identificacao + " foi deletado com sucesso, se precisar deletar mais um animal, informe o id abaixo: <br>"
					+ "<a href=index.jsp>Clique para voltar para index</a>"); 
		} else {
			request.setAttribute("message", "Problema para deletar.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar.jsp");
		dispatcher.forward(request, response);
	}

}
