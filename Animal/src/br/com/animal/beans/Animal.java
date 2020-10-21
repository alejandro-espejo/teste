package br.com.animal.beans;

public class Animal {
	private int identificacao;
	private String especieAnimal;
	private String nomeAnimal;
	private int peso;

	public int getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}

	public String getEspecieAnimal() {
		return especieAnimal;
	}

	public void setEspecieAnimal(String especieAnimal) {
		this.especieAnimal = especieAnimal;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
