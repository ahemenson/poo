

import java.util.*;

public class Pedido {
	
	private long numeroDoPedido ;
	
	private Cliente cliente;
	
	List <ItemDePedido> itens;
	
	public Pedido(long numeroPedido ){
		itens =  new ArrayList();
		numeroDoPedido=numeroPedido;
		
	}
	
	public List <ItemDePedido> getItens(){
		return itens;
	}
	
	public void adicionaItem(ItemDePedido item ){
		this.itens.add(item);
	}
	
	public long getNumeroDoPedido(){
		return this.numeroDoPedido;
	}
	
	public void setNumeroDoPedido(long numPedido ){
		this.numeroDoPedido = numPedido;
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}
	
	public void setCliente(Cliente c){
		this.cliente = c;
	}
	
	
	
}
