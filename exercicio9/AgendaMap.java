

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AgendaMap implements AgendaIf {
	
	private Map<String,Contato> contatos;
	 
	private GravadorDeContatos gravador = new GravadorDeContatos();
	
	
	public AgendaMap(){
		try{
			this.contatos = gravador.leContatosMap();
		}catch(IOException e){
			System.err.println(e.getMessage());
			this.contatos= new HashMap <String,Contato>();
		}
	}
	
	public void adiciona(String nome, String telefone ){
		
		this.contatos.put(nome,new Contato(nome, telefone));
		
	}
	
	public void remove(String nome)throws ContatoInexistenteException{
		boolean achou= false;
		for(Contato c: contatos.values()){
			if(c.getNome().contains(nome)){
				contatos.remove(nome);
				achou=true;
				return;
			}
		
		}
		
		if(achou==false){
			throw new ContatoInexistenteException("Contato Inexistente!!!");
		}
		
	}
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException{
		for(Contato c : contatos.values()){
			if(c.getNome().contains(nome)){
				return c;
			}
			
		}
		throw new ContatoInexistenteException("Contato não cadastrado");
	}
	
	@Override
	public Collection<Contato> getContatos(){
		Collection colecaoContatos = new ArrayList();
		
		colecaoContatos.addAll(this.contatos.values());
						
		return colecaoContatos;
	}
	
	public Iterator<Contato> getContatosOrdenados(){
		
		List <Contato> contatosOrdenados = new ArrayList <Contato>();

		contatosOrdenados.addAll(this.contatos.values());

        Collections.sort(contatosOrdenados);

        return contatosOrdenados.iterator();
	}

		
	public void sairDoSistema(){
		try{
			this.gravador.gravaContatosMap(this.contatos);
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}

	
}
