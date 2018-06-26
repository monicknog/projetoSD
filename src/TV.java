import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TV {
	
	static Senha senha = new Senha();
	
	public void chamarSenha() {
		try {
			Socket socket = new Socket("127.0.0.1", 12345);
			ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
			
			senha = (Senha) entrada.readObject();
			
			System.out.println("SENHA: " + senha.getTipo() + senha.getValor());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
