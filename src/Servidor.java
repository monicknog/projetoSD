import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Servidor {
	public static void main(String[] args) {
		
		List<Senha> senhas = new LinkedList<Senha>();
		Senha senha = new Senha();
		
		try {
			ServerSocket srv = new ServerSocket(12345);
			
			System.out.println("Servidor iniciado!");
			
			while(true) {
				System.out.println("Aguardando cliente...");
				Socket socket = srv.accept();
				
				ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream()); 
				ObjectOutputStream saida;
				
				if(entrada.readLine().equals("SIM")) {
					senha = senhas.get(0);
					
					saida = new ObjectOutputStream(socket.getOutputStream());
					saida.writeObject(senha);
					
					
					ObjectOutputStream enviarTV = new ObjectOutputStream(socket.getOutputStream());
					enviarTV.writeObject(senha);
					
				}else if(entrada.readObject().equals(senha)) {
					senha = (Senha) entrada.readObject();
					
					if(senha.getTipo().equals("N")) {
						senhas.add(senha);
					}else if(senha.getTipo().equals("P")) {
						senhas.add(0, senha);
					}
				}
					
				srv.close();
				socket.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
}

 class SRVCliente implements Runnable{
	 
	 private String terminal;
	 
	 public SRVCliente(String terminal) {
		// TODO Auto-generated constructor stub
		 this.terminal = terminal;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(terminal.equals("TV")) {
			
		}else if(terminal.equals("TA")) {
			
		}
		
	}	
	
}
