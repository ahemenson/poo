

import java.io.Serializable;

public class ItemDePedido implements Serializable{

	private int quantidade;
	private String codProduto;
	private double valorUnitario;
	
	public ItemDePedido(String codigo, int quant, double valor){
		this.quantidade = quant;
		this.codProduto = codigo;
		this.valorUnitario = valor;
	}
	
	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade(){
		return this.quantidade;
	}
	public void setQuantidade(int quant){
		this.quantidade = quant;
	}
	
	public double getSubTotal(){
		return this.valorUnitario*this.quantidade;
	}
	
	public String toString(){
		return "CODIGO DO PRODUTO ("+this.codProduto+")\nQUANTIDADE (" +this.quantidade+")\nVALOR UNITÁRIO [R$: "+this.valorUnitario+"]";
	}
}
