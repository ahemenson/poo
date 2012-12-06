


import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class Agenda implements AgendaIf, Serializable{ 
	
	private List<Contato> contato;
	GravadorDeContatos gravador= new GravadorDeContatos();
	
	public Agenda(){
		try{
			this.contato = gravador.leContatos();
			
		}catch(IOException e){
			this.contato= new ArrayList<Contato>();
		}
	}
	
	public void adiciona(String nome, String telefone ){

		try {
			//No caso de existir o mesmo contato na lista
			Contato c = pesquisaContato(nome);
			c.setTelefone(telefone);
		} catch (ContatoInexistenteException e) {
			//No caso do contato ser novo 
			contato.add(new Contato(nome, telefone));
		}
		
		/**
		try {
			Contato c = pesquisaContato(nome);
			this.remove(nome);
		} catch (ContatoInexistenteException e) {
			
		}
		contato.add(new Contato(nome, telefone));
		 * 
		 */
		
	}
	
	public void remove(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contato){
			if(c.getNome().equals(nomeContato)){
				contato.remove(c);
				return;
				
			}
		}
		
		throw new ContatoInexistenteException("contato Inexistente");
	}
	
	public Contato pesquisaContato(String nomeContato) throws ContatoInexistenteException{
		for(Contato c : this.contato){
			if(c.getNome().equals(nomeContato)){
				return c;
			}
		}
		
		throw new ContatoInexistenteException(" Contato não cadastrado");
	}
	
	public void imprimirTodos(){
		for(Contato c: this.contato){
			System.out.println("O Nome é : "+ c.toString());
		}
	}
	
	public void sairDoSistema(){
		try{
			this.gravador.gravaContatos(this.contato);
		}catch(IOException erro){
			System.err.println(erro.getMessage());
			
			
		}
	}

	
	public Collection<Contato> getContatos() {
		Collection <Contato> contato = new ArrayList<Contato>();
		for(Contato c: this.contato){
			contato.add(c);
			
		}
		return contato;
	}

	
	public Iterator<Contato> getContatosOrdenados() {
		
		Collections.sort(this.contato);
						
		return this.contato.iterator();
		
	}
	
	}

