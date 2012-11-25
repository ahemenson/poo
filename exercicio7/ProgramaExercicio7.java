

import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import org.omg.CORBA.Object;

public class ProgramaExercicio7 {
	
	public static void main(String [] args) {
		
		AgendaIf agenda = null;
						
		String tipoLista="",nome, telefone, opcao="";
		boolean libera=false;
		
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
			opcao=JOptionPane.showInputDialog("***"+" AGENDA COM "+tipoLista+"***"+"\nDIGITE 1(CADASTRAR CONTATO)\nDIGITE 2(REMOVER CONTATO)\nDIGITE 3(CONSULTAR CONTATO)\nDIGITE 4(SAIR)\n");
			
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
						
		}while(!opcao.equals("4"));
		
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
	
		

		
		
		
	


