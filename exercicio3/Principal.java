import java.util.Scanner;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double valor = 0;		
		
		System.out.println("informe seus tr�s pedidos");
				
		int numPedido=1;
				
		boolean continua = true;
		do{
			System.out.println("cod produto");
			String cod=input.next();
			
			System.out.println("quant produto");
			String quant=input.next();
			
			System.out.println("valor unit�rio do produto");
			String valorUnitario=input.next();
									
			if(cod.equals("0")||quant.equals("0")||valorUnitario.equals("0")){
						
				continua=false;
				quant="0";
				valorUnitario="0";
			}
							
			ItemDePedido itens = new ItemDePedido(cod,Integer.parseInt(quant),Double.parseDouble(valorUnitario));
								
			Pedido pedido = new Pedido(numPedido);
			pedido.adicionaItem(itens);
			valor=pedido.getValorTotal()+valor;
						
			numPedido++;
		
		}while (continua!=false);
		
		System.out.println(" Valor total:R$ ["+valor+"]");
		
	}

}
