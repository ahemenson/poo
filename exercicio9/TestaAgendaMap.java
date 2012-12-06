
import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestaAgendaMap {
	
	private AgendaMap agendaMap;
	
	@Before
	public void setUp(){
		this.agendaMap = new AgendaMap();
	}
	
	@After
	public void tearDown(){
		File f = new File("AgendaMap.txt");
		if(f.exists()){
			f.delete();
		}
	}
	
	
	@Test
	public void testaAdiciona(){
				
		agendaMap.adiciona("Ana", "813567");
		agendaMap.adiciona("Ana", "332223");
				
		try {
			//testando se o contato foi substituido pelo recente
			Contato c = agendaMap.pesquisaContato("Ana");
			assertTrue(c.getNome().equals("Ana")&&c.getTelefone().equals("332223"));
		} catch (ContatoInexistenteException e) {
			fail("não era pra falhar");
			
		}
		
	}
	
	@Test
	public void testaRemove() throws ContatoInexistenteException{
				
		agendaMap.adiciona("Maria", "2222222");
		
		
		try{
			//testando remover contato existente
			Contato c = agendaMap.pesquisaContato("Maria");
			assertEquals("2222222", c.getTelefone());
			agendaMap.remove("Maria");
		}catch(ContatoInexistenteException e){
			fail("não era pra falhar");
		}
		
		try{
			//testando remover contato inexistente
			agendaMap.pesquisaContato("Maria");
			fail("devia ter lançando uma exceção");
		}catch(ContatoInexistenteException e){
			//Ok
		}

	}
	
	@Test
	public void testeContatosSemOrdenacao(){
				
		agendaMap.adiciona("Joao", "3333");
		agendaMap.adiciona("Aline", "1111");
		agendaMap.adiciona("Bruno", "2222");
		
		Collection<Contato> contatosAchados= agendaMap.getContatos();
		
		assertTrue(contatosAchados.size() == 3);
		
		for (Contato c : contatosAchados) {
			assertTrue(c.getNome().equals("Bruno") || c.getNome().equals("Joao") || c.getNome().equals("Aline"));
		}
	}
	
	
	@Test
	public void testeContatosComOrdenacao(){
		
		
		agendaMap.adiciona("Joao", "3333");
		agendaMap.adiciona("Aline", "1111");
		agendaMap.adiciona("Bruno", "2222");
		
		Iterator<Contato> contatosAchados= agendaMap.getContatosOrdenados();
		
		assertTrue(contatosAchados.hasNext());
		
		assertEquals("Aline",contatosAchados.next().getNome());
		assertEquals("Bruno",contatosAchados.next().getNome());
		assertEquals("Joao",contatosAchados.next().getNome());
		
		
		
	}
	
	

}
