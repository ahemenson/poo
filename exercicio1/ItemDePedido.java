

public class ItemDePedido {

	private int quantidade;
	private long codProduto;
	private double valorUnitario;
	
	public ItemDePedido(int quantidade , long codProduto ,long valorUnitario){
		this.quantidade = quantidade;
		this.codProduto = codProduto;
		this.valorUnitario = valorUnitario;
	}
	
	public int getQuantidade(){
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	
	public long getCodProduto(){
		return this.quantidade;
	}
	
	public void setCodProduto(long codProduto){
		this.codProduto = codProduto;
	}
	
	public double getValorUnitario(){
		return this.valorUnitario;
	}
	
	public void setValorUnitario(double valorUnitario){
		this.valorUnitario = valorUnitario;
	}
	
	
	
}
