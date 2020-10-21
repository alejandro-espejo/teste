package br.com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.animal.beans.Animal;
import br.com.animal.conexao.ConexaoFactory;

public class AnimalDAO {
		static Connection conexao;

	
	 public AnimalDAO() throws Exception { 
		 conexao = new ConexaoFactory().getConnection(); 
		}
	 
	public static boolean gravar(Animal animal) {
		boolean resultado = false;
		try {
			String sql = "INSERT INTO animal (especieAnimal, nomeAnimal, peso) VALUES (?,?,?)";
			Connection conexao;
			conexao = new ConexaoFactory().getConnection();
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, animal.getEspecieAnimal());
			estrutura.setString(2, animal.getNomeAnimal());
			estrutura.setInt(3, animal.getPeso());
			estrutura.execute();
			estrutura.close();
			resultado = true;
		} catch (SQLException e) {
			System.out.print("Erro: ");
			e.printStackTrace();
		}
		return resultado;
	}

	public static boolean deletar(int identificacao) {
		int recebeIdentificacao = identificacao;
		boolean resultado = false;
		try {
			String sql = "DELETE FROM animal WHERE identificacao=(?)";
			Connection conexao;
			conexao = new ConexaoFactory().getConnection();
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, recebeIdentificacao);
			estrutura.executeUpdate();
			estrutura.close();
			resultado = true;
		} catch (SQLException e) {
			System.out.print("Erro: ");
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ArrayList<Animal> buscarTodos (Animal animal) { //throws Exception {
		String sql = "SELECT * FROM animal";
		ArrayList<Animal> lista = new ArrayList<Animal>();
		try {
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			ResultSet resultadoDados = estrutura.executeQuery();
			while(resultadoDados.next()) {
				Animal ani = new Animal();
				ani.setIdentificacao(resultadoDados.getInt("identificacao"));
				ani.setEspecieAnimal(resultadoDados.getString("especieAnimal"));
				ani.setNomeAnimal(resultadoDados.getString("nomeAnimal"));
				ani.setPeso(resultadoDados.getInt("peso"));
				lista.add(ani);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
			return lista;
	}
}
