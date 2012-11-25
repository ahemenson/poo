

import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class GravadorDeContatos{
	
	
	/**
	 * 
	 * @return retorna uma lista de contatos do tipo List gravados no arquivo Agenda.txt
	 * @throws IOException trata os possiveis erros de arquivo não encontrado e classe não encontrada
	 */
	public List<Contato> leContatos( ) throws IOException{
		ObjectInputStream in = null;
		
		try{
			in = new ObjectInputStream(new FileInputStream("Agenda.txt"));
			return (List<Contato>) in.readObject();
		}catch(FileNotFoundException erro){
			throw new IOException("arquivo contatos.txt não foi encontrado");
		}catch(ClassNotFoundException erro){
			throw new IOException("arquivo contatos.txt não foi encontrado");
		}
		finally{
			if(in!=null){
				in.close();
			}
		}
	}
	/**
	 * 
	 @return retorna uma lista de contatos do tipo Map gravados no arquivo AgendaMap.txt
	 *@throws IOException trata os possiveis erros de arquivo não encontrado e classe não encontrada
	 */
	public Map<String,Contato> leContatosMap( ) throws IOException{
		ObjectInputStream in = null;
		
		try{
			in = new ObjectInputStream(new FileInputStream("AgendaMap.txt"));
			return (Map<String,Contato>) in.readObject();
		}catch(FileNotFoundException erro){
			throw new IOException("arquivo contatos.txt não foi encontrado");
		}catch(ClassNotFoundException erro){
			throw new IOException("arquivo contatos.txt não foi encontrado");
		}
		finally{
			if(in!=null){
				in.close();
			}
		}
	}
	/**
	 * 
	 * @param contatos é uma coleção de objetos de tipo List
	 * @throws IOException trata os possiveis erros de arquivo não encontrado 
	 */
	public void gravaContatos(List<Contato> contatos) throws IOException{
		ObjectOutputStream out = null;
		
		try{
			out = new ObjectOutputStream(new FileOutputStream("Agenda.txt"));
			out.writeObject(contatos);
		}catch (FileNotFoundException e){
			throw new IOException("arquivo contatos.txt não encontrado",e);
		}catch (IOException e){
			throw e;
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
	}	
		
	/** @param contatos é uma coleção de objetos de tipo Map
	 * @throws IOException trata os possiveis erros de arquivo não encontrado 
	 */	
	public void gravaContatosMap(Map<String,Contato> contatos) throws IOException{
		ObjectOutputStream out = null;
		
		try{
			out = new ObjectOutputStream(new FileOutputStream("AgendaMap.txt"));
			out.writeObject(contatos);
		}catch (FileNotFoundException e){
			throw new IOException("arquivo contatos.txt não encontrado",e);
		}catch (IOException e){
			throw e;
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
	}	
		
		


}
