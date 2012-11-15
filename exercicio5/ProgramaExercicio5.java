

public class ProgramaExercicio5 {
	
	public static void main(String [] args) {
		
		Agenda agenda = new Agenda();
		
		agenda.adiciona("lucas", "8182-8282");
				
		try{
			
			System.out.println(agenda.pesquisaContato("lucas").toString());
						
		}catch(ContatoInexistenteException e){

			System.err.println(e.getMessage());
		}
		
		try{
			
			System.out.println(agenda.pesquisaContato("maria").toString());
						
		}catch(ContatoInexistenteException e){

			System.err.println(e.getMessage());
		}
						
		
	}

}
