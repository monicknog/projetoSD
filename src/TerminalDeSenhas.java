import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class TerminalDeSenhas {
	
	private static int normal = 0;
	private static int priori = 0;
	
	public static void gerarSenha(Senha senha) {
		try {
			
			Socket socket = new Socket("127.0.0.1", 12345);
			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
			saida.writeObject(senha);
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static int getNormal() {
		return normal + 1;
	}

	public static int getPriori() {
		return priori + 1;
	}
	
	public static void main(String[] args) {
		
		Scanner tc = new Scanner(System.in);
		Senha senha = new Senha();
		int op;
		
		while(true) {
			System.out.println("Terminal de Senhas");
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Senha Normal");
			System.out.println("2 - Senha Prioritária");
			op = tc.nextInt();
			
			switch (op) {
			case 1:
				senha.setTipo("N");
				senha.setPrioridade(0);
				senha.setValor(getNormal());
				
				gerarSenha(senha);
				
				break;
	
			case 2:
				senha.setTipo("P");
				senha.setPrioridade(1);
				senha.setValor(getPriori());
				
				gerarSenha(senha);
				
				break;
				
			default:
				System.out.println("Selecione uma opção válida.");
				break;
			}
		}	
	}

}
