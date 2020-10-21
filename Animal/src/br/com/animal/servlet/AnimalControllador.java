package br.com.animal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.animal.beans.Animal;
import br.com.animal.dao.AnimalDAO;

/**
 * Servlet implementation class AnimalControllador
 */
@WebServlet("/AnimalControllador")
public class AnimalControllador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object listaResultado;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalControllador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Animal animal = new Animal();
			AnimalDAO animalDAO = new AnimalDAO();
			ArrayList<Animal> listaResul = animalDAO.buscarTodos(animal);
			for (Animal a : listaResul) {
				System.out.println("Identificacao: " + a.getIdentificacao() + "Especie: " + a.getEspecieAnimal() + "Nome: " + a.getNomeAnimal() + "Peso: " + a.getPeso());
				request.setAttribute("listaResul", listaResul);
				RequestDispatcher saida = request.getRequestDispatcher("listaAnimal.jsp");
				saida.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.print("Erro: ");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public Object getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(Object listaResultado) {
		this.listaResultado = listaResultado;
	}

}
