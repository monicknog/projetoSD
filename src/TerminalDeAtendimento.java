import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TerminalDeAtendimento {
	
	static Senha senha = new Senha();
	
	public static void solicitarSenha() {
		try {
			
			Socket socket = new Socket("127.0.0.1", 12345);
			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
			saida.writeChars("SIM");
			
			ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
			senha = (Senha) entrada.readObject();
			
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner tc = new Scanner(System.in);
		String op;
		
		while (true) {
			System.out.println();
			System.out.println("Terminal de Atendimento");
			System.out.println("Solicitar senha?");
			System.out.println("S - Sim");
			System.out.println("N - Não");
			op = tc.nextLine();
			
			switch (op) {
			case "S":
				solicitarSenha();
				
				TV tv = new TV();
				tv.chamarSenha();
				break;

			case "N":
				break;
				
			default:
				System.out.println("Selecione uma opção válida.");
				break;
			}
			
		}
		
	}

}
