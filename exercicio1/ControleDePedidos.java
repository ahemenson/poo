

import java.util.ArrayList;
import java.util.List;

public class ControleDePedidos implements InterfaceSistemaDeControle{

	List <Pedido> pedidos;
	
	public ControleDePedidos(){
		pedidos = new ArrayList();
	}
		
	public void adicionaPedido(Pedido p) {
		pedidos.add(p);
	}


	public List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto ) {
		
		for (Pedido aux: pedidos) {
			if(aux.getNumeroDoPedido() == codProduto){
				//aux.
			}
		}
		
		
		return null;
	}

	
	public void removePedido(long numProduto ) {
		pedidos.remove(numProduto);	
		
	}
	
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
				
		int cont =0;
		for (Pedido aux: pedidos) {
			if(aux.getCliente().getNome().equalsIgnoreCase(nomeCliente)){
				cont++;
			}
			
		}
		
		return cont;
	}

}
