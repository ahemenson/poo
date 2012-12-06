


import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestaAgenda {
	
	private Agenda agenda;
	
	@Before
	public void setUp(){
		this.agenda = new Agenda();
	}
	
	@After
	public void tearDown(){
		File f = new File("Agenda.txt");
		if(f.exists()){
			f.delete();
		}
	}
	
	@Test
	public void adicionaTeste() {
				
		agenda.adiciona("lucas", "2111");
		agenda.adiciona("lucas", "3222");
		try {			
			//testando se o contato foi substituido pelo recente
			Contato c = agenda.pesquisaContato("lucas");
			assertEquals("3222", c.getTelefone());
			assertTrue(c.getTelefone().equals("3222"));
			
		} catch (ContatoInexistenteException e) {
			fail("n�o era pra falhar");
		}

	}
	
	
	@Test
	public void removeTeste() {
			
		agenda.adiciona("Pedro", "8111");
		
		try {
			//testando remover contato existente
			Contato c = agenda.pesquisaContato("Pedro");
			assertEquals("8111", c.getTelefone());
			agenda.remove("Pedro");

		} catch (ContatoInexistenteException e) {
			fail("n�o era pra falhar");
		}
		
		try {
			//testando remover contato Inexistente
			agenda.pesquisaContato("Pedro");
			fail("deveria lan�ar a exce��o");
		} catch (ContatoInexistenteException e) {
			//Ok
		}
		
	}
	
	@Test
	public void pesquisaTeste() {
		
		try {
			//pesquisa contato existente
			agenda.adiciona("Ana", "555");
			agenda.pesquisaContato("Ana");
		} catch (ContatoInexistenteException e) {
			fail("n�o deveria lan�ar a exce��o");
		}
				
		try {
			//pesquisa contato inexistente
			agenda.adiciona("Ana", "555");
			agenda.pesquisaContato("Joana");
			fail("deveria lan�ar a exce��o");
		} catch (ContatoInexistenteException e) {
			//Ok
		}
	}
	
	
	@Test
	public void ContatosSemOrdenacao() {
		
		agenda.adiciona("Ot�vio", "7444");	
		agenda.adiciona("Alice", "8111");
		agenda.adiciona("Gil", "9222");

		Collection<Contato> contatosAchados = agenda.getContatos();
		
		assertTrue(contatosAchados.size() == 3);
				
		for (Contato c : contatosAchados) {
			assertTrue(c.getNome().equals("Ot�vio") || c.getNome().equals("Alice") || c.getNome().equals("Gil"));
		}
	}
	
	
	@Test
	public void ContatosComOrdenacao() {
				
		agenda.adiciona("Ot�vio", "7444");	
		agenda.adiciona("Alice", "8111");
		agenda.adiciona("Gil", "9222");

		Iterator<Contato> contatosAchados = agenda.getContatosOrdenados();
		
		assertTrue(contatosAchados.hasNext());
		
		//testando se os contatos est�o ordenados
		assertEquals("Alice",contatosAchados.next().getNome());
		assertEquals("Gil",contatosAchados.next().getNome());
		assertEquals("Ot�vio",contatosAchados.next().getNome());

	}
	
	
}
