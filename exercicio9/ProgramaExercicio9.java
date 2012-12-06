

import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;
import org.omg.CORBA.Object;

/**
 * 
 * Exercício 8: lista contatos ordenados e não ordenados
 *
 */


public class ProgramaExercicio9 {
	
	public static void main(String [] args) {
		
		AgendaIf agenda = null;
						
		String tipoLista="",nome, telefone, opcao="",concat="";
		boolean libera=false;
		int opcaoListagem=0;
		
		//Menu Inicial
		while (libera==false){
			tipoLista = JOptionPane.showInputDialog("CRIE UMA AGENDA\nDIGITE 'MAP' OU 'LIST' ").toUpperCase();
			if(tipoLista.equals("LIST")){
				agenda = new Agenda();
				libera=true;
			}	
			else if (tipoLista.equals("MAP")){
				agenda = new AgendaMap();
				libera=true;
			}
		}
		
		//Menu de operações
		do{
			opcao=JOptionPane.showInputDialog("***"+" AGENDA COM "+tipoLista+"***"+"\nDIGITE 1(CADASTRAR CONTATO)\nDIGITE 2(REMOVER CONTATO)" +
					"\nDIGITE 3(CONSULTAR CONTATO)\nDIGITE 4(LISTAR CONTATOS SEM ORDENAÇÂO)\nDIGITE 5(LISTAR CONTATOS COM ORDENAÇÂO)\nDIGITE 6(SAIR)\n");
			
			//adiciona contato
			if(opcao.equals("1")){
				nome = JOptionPane.showInputDialog("DIGITE O NOME DO NOVO CONTATO");
				telefone = JOptionPane.showInputDialog("DIGITE O TELEFONE DO NOVO CONTATO");
				agenda.adiciona(nome, telefone);
				JOptionPane.showMessageDialog(null, "CONTATO "+nome+" ADICIONADO!");
			}
			
			//remove contato
			else if(opcao.equals("2")){
				nome = JOptionPane.showInputDialog("REMOVER CONTATO\nDIGITE O NOME CONTATO");
				
				try{
					agenda.remove(nome);
					JOptionPane.showMessageDialog(null, "CONTATO "+nome+" REMOVIDO!");
				}catch(ContatoInexistenteException e){
					JOptionPane.showMessageDialog(null, e.getMessage().toUpperCase());
				}
			}
			
			//pesquisa contato
			else if(opcao.equals("3")){
				nome = JOptionPane.showInputDialog("CONSULTAR CONTATO\nDIGITE O NOME CONTATO");
				
				try{
					JOptionPane.showMessageDialog(null, agenda.pesquisaContato(nome));
				}catch(ContatoInexistenteException e){
					JOptionPane.showMessageDialog(null, e.getMessage().toUpperCase());
				}
			}
			
			//listar contatos não ordenados
			else if(opcao.equals("4")){
									
				Collection <Contato> contatos = agenda.getContatos();
				concat="CONTATOS NÃO ORDENADOS";
				for(Contato c: contatos){
					concat+="\n"+c.toString();
				}
				JOptionPane.showMessageDialog(null,concat);
			}
			
			//listar contatos ordenados
			else if(opcao.equals("5")){
								
				Iterator <Contato> contatos = agenda.getContatosOrdenados();
				concat="CONTATOS ORDENADOS";
				while(contatos.hasNext()){
					concat+="\n"+contatos.next();
				}
				JOptionPane.showMessageDialog(null,concat);
			}
				
		}while(!opcao.equals("6"));
		
		//grava contatos List
		if(tipoLista.equals("LIST")){
			((Agenda) agenda).sairDoSistema();
		}
		//grava contatos Map
		else if(tipoLista.equals("MAP")){
			((AgendaMap) agenda).sairDoSistema();
		}
		
		
	
	
	}
}
	
		

		
		
		
	


