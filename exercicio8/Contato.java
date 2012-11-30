

import java.io.Serializable;

public class Contato implements Serializable,Comparable <Contato> {
	
	private String nome, telefone;
			
	public Contato(String nome,String telefone){
		
		this.nome=nome;
		this.telefone=telefone;
	}
			
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
		
	public String getTelefone(){
		return this.telefone;
	}
	
	public void setTelefone(String telefone){
		this.telefone=telefone;
	}
	
	public String toString(){
		return this.nome+" "+this.telefone;
	}

	
	public int compareTo(Contato o) {
		
		if(this.nome.compareTo(o.getNome())<0){
			return -1;
		}
		else if(this.nome.compareTo(o.getNome())>0){
			return 1;
		}
		else{
			return 0;
		}
		
	}
}
