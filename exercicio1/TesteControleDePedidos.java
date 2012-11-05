

public class TesteControleDePedidos {

	
	public static void main(String[] args) {
		
		ControleDePedidos controlePedidos = new ControleDePedidos();
		
		Cliente clienteA =  new Cliente("pedro");
		
		Pedido pedido1 = new Pedido(012);
		
		
		pedido1.setCliente(clienteA);
						
		controlePedidos.adicionaPedido(pedido1);
			
		Pedido pedido2 = new Pedido(024);
			
		pedido2.setCliente(clienteA);
		
		controlePedidos.adicionaPedido(pedido2);
		
		System.out.println("\nqt de pedidos do clienteA "+controlePedidos.calculaQuantidadeDePedidosDoCliente("pedro"));
		
		
		
		
		
		

	}

}
