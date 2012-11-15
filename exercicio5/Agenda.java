

import java.util.*;

public class Agenda implements AgendaIf{ 
	
	private List<Contato> contatos;
	
	public Agenda(){
		
		this.contatos= new ArrayList <Contato>();
		
	}
	
	public void adiciona(String nome, String telefone ){
		
		this.contatos.add(new Contato(nome, telefone));
		
	}
	
	public void remove(String nome)throws ContatoInexistenteException{
		boolean achou= false;
		for(Contato c: contatos){
			if(c.getNome().equals(nome)){
				contatos.remove(c);
				achou=true;
				return;
			}
		
		}
		
		if(achou==false){
			throw new ContatoInexistenteException("Contato Inexistente!");
		}
		
	}
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException{
		for(Contato c : contatos){
			if(c.getNome().equals(nome)){
				return c;
			}
			
		}
		throw new ContatoInexistenteException("Contato não cadastrado");
	}
		
		
}


