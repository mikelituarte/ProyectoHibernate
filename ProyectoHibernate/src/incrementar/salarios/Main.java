package incrementar.salarios;

public class Main {

	public static void main(String[] args) {
		IncrementarSalarios i = new IncrementarSalarios();
		try{
		//i.incrementarSalario20();
		//i.desconectarBBDD();
		i.decrementarSalario20();
		}
		catch(Exception e){
			
		}
		finally{
		i.desconectarBBDD();
		}
		System.out.println("---------FIN-PROGRAMA----------------");
	}
}
