

import java.io.Serializable;

public class Cliente implements Serializable{

	private String nome;
	
	public Cliente(){
		this.nome = "Fulano";
	}
	public Cliente(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
}
