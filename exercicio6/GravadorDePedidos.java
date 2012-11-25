

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;



public class GravadorDePedidos implements Serializable{
		
	
	public List<Pedido> lePedidos()throws IOException{
		ObjectInputStream entrada = null;
		
		try{
			entrada = new ObjectInputStream (new FileInputStream("Pedidos.txt"));
			return (List<Pedido>) entrada.readObject();
		
		}catch(FileNotFoundException e){
			throw new IOException ("arquivo Pedido.txt não encontrado",e);
		}catch(ClassNotFoundException e){
			throw new IOException ("arquivo Pedido.txt não encontrado",e);
		}
		
		finally{
			if(entrada!=null){
				entrada.close();
			}
		}
	}
	
	
	public void gravaPedidos(List<Pedido> pedidos) throws IOException{
		ObjectOutputStream saida = null;
		
		try{
			saida = new ObjectOutputStream(new FileOutputStream("Pedidos.txt"));
			saida.writeObject(pedidos);
		}catch(FileNotFoundException e){
			throw new IOException ("arquivo contatos.txt não encontrado",e);
		}catch(IOException e){
			throw e;
		}
		
		finally{
			if(saida!=null){
				saida.close();
			}
		}
		
	}
	
}

