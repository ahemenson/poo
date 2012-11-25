


/**
  *Sistema que envia um pedido do cliente e busca um pedido efetuado.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ControleDePedidos controleDePedidos = new ControleDePedidos();
								
		String nome,opcao,cod;
		int quant=0;
		double valorUnitario=0;
		long numPedido=1;
		
		//menu de escolhas
		do{
			System.out.println("\nDIGITE 1(FAZER PEDIDO)\nDIGITE 2(CONSULTAR PEDIDO)\nDIGITE 3(SAIR)\n");
			opcao = input.next();
			//fazendo um pedido
			if(opcao.equals("1")){
				
				System.out.println("NÚMERO DO PEDIDO EFETUADO ["+numPedido+"]");
											
				System.out.println("\nDIGITE O CODIGO DO PRODUTO ex: coca,pizza,suco...");
				cod = input.next();
				
				System.out.println("INFORME A QUANTIDADE");
				quant = input.nextInt();
									
				System.out.println("INFORME O VALOR UNITÁRIO DO PRODUTO");
				valorUnitario = input.nextDouble();
																
				Pedido pedido = new Pedido(numPedido);
								
				ItemDePedido itens = new ItemDePedido(cod,quant,valorUnitario);
								
				pedido.adicionaItem(itens);
										
				controleDePedidos.adicionaPedido(pedido);
				
				numPedido++;
								
			}
			
			//buscando um pedido efetuado
			else if(opcao.equals("2")){
				System.out.println("INFORME O CODIGO DO PRODUTO ex: coca,pizza,suco...");
				cod = input.next();
				System.out.println(controleDePedidos.pesquisaPedidosIncluindoProduto(cod).toString());
				System.out.println();
			}
					
			
			
		}while(!opcao.equals("3"));
		
		controleDePedidos.gravaPedidos();
		
		
		
		
		
				
					
	}
}

