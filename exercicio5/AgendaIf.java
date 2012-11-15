

public interface AgendaIf {

	public void adiciona(String nome,String telefone);
	public void remove(String nome)throws ContatoInexistenteException;
	public Contato pesquisaContato(String nome)throws ContatoInexistenteException;
}
