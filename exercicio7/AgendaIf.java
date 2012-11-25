

public interface AgendaIf {
	/**
	 * Adiciona um nome e telefone na agenda
	 * @param nome 
	 * @param telefone
	 */
	public void adiciona(String nome,String telefone);
	/**
	 * Remove um contado da agenda
	 * @param nome
	 * @throws ContatoInexistenteException
	 */
	public void remove(String nome)throws ContatoInexistenteException;
	/**
	 * Pesquisa um contato na agenda
	 * @param nome
	 * @return retorna o contato
	 * @throws ContatoInexistenteException
	 */
	public Contato pesquisaContato(String nome)throws ContatoInexistenteException;
}
