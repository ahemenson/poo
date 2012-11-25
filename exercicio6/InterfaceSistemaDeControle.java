

import java.util.List;

/**
 *  
 * implementa seus metodos na classe ControleDePedidos
 * que será responsável pelo controle dos pedidos efetuados 
 * pelo cliente
 * 
 */

public interface InterfaceSistemaDeControle {
		
	/**
	 * Adiciona um pedido feito pelo cliente
	 * @param Pedido
	 */
	public void adicionaPedido(Pedido p);
	/**
	 * Pesquisa o produto pelo seu codigo
	 * @param codProduto
	 */
	public List <Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	/**
	 * Remove o pedido efetuado pelo cliente atraves do numero do pedido
	 * @param numeroPedido
	 */
	public void removePedido(long numeroPedido);
}
