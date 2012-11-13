package br.ufpb.sistemapedidos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Controla os pedidos do cliente
 *
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List <Pedido> pedidos;
	
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	/**
	 * busca a quantidade de pedidos efetuados por determinado cliente
	 * @return retorna a quantidade de pedidos
	 */
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		
		int cont = 0;
		for (Pedido p: this.pedidos){
			if (p.getCliente().getNome().equals(nomeCliente)){
				cont++;
			}
		}
		return cont;
	}
	/**
	 * adiciona um pedido do cliente na lista
	 * @param objeto pedido	
	 */
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);

	}

	/**
	 * pesquisa na lista de pedidos atrav�s do c�digo de um produto 
	 * @param � passado o codigo do produto
	 * @return retorna uma lista com os produtos encontrados com o codigo correspondente
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) {
		List <Pedido> pedidosProcurados = new LinkedList<Pedido>();
		for (Pedido p: this.pedidos){
			List<ItemDePedido> itens = p.getItens();
			for (ItemDePedido it: itens){
				if (it.getCodProduto().equals(codProduto)){
					pedidosProcurados.add(p);
				}
			}
		}
		//TODO: ajeitar para verificar itens repetidos
		return pedidosProcurados;
	}

	/**
	 * remove um pedido da lista por meio do n�mero do pedido
	 * @param � passado o numero do Pedido
	 */
	public void removePedido(long numeroPedido) {
		for (Pedido p: this.pedidos){
			if (p.getNumeroPedido()== numeroPedido){
				this.pedidos.remove(p);
				break;
			}
		}

	}

}
