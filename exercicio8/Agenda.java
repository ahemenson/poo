

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Agenda implements AgendaIf{ 
	
	private List<Contato> contatos;
	 
	private GravadorDeContatos gravador = new GravadorDeContatos();
	
	
	public Agenda(){
		try{
			this.contatos = gravador.leContatos();
		}catch(IOException e){
			System.err.println(e.getMessage());
			this.contatos= new ArrayList <Contato>();
		}
	}
	
	public void adiciona(String nome, String telefone ){
		
		this.contatos.add(new Contato(nome, telefone));
		
	}
	
	public void remove(String nome)throws ContatoInexistenteException{
		boolean achou= false;
		for(Contato c: contatos){
			if(c.getNome().equalsIgnoreCase(nome)){
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
			if(c.getNome().equalsIgnoreCase(nome)){
				return c;
			}
			
		}
		throw new ContatoInexistenteException("Contato não cadastrado");
	}
	
	public Collection<Contato> getContatos(){
		Collection colecaoContatos = new ArrayList();
		
		colecaoContatos.addAll(this.contatos);
				
		return colecaoContatos;
	}
	
	public Iterator<Contato> getContatosOrdenados(){
		Collections.sort(this.contatos);
		
		return this.contatos.iterator();
	}
		
	public void sairDoSistema(){
		try{
			this.gravador.gravaContatos(this.contatos);
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}

	
}

