
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MGM_Cliente {

    private static Socket socket;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        String sentenca; 
        String sentencaModificada;  
        
        // cria o stream do teclado
        BufferedReader cadeiaUsuario = new BufferedReader(new InputStreamReader(System.in));
        try {
          ////   25.7.126.42  ip de um dos membros do grupo - Attair
            socket = new Socket("127.0.0.1", 6789);
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());
            // cria os streams (encadeamentos) de entrada e saida com o servidor
            DataOutputStream clienteParaServidor = new DataOutputStream(socket.getOutputStream());
            BufferedReader cadeiaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//			Recebe alguns dados do usuário
            System.out.println("****************");
            System.out.println("Conexão perfeita");
            System.out.println("****************");
            System.out.println("Digite uma palavra e envie para o servidor: ");
            
            
            sentenca = cadeiaUsuario.readLine();
            
            
            // envia a linha para o server
            
            
            clienteParaServidor.writeBytes(sentenca + '\n');

            // lê uma linha do server
            sentencaModificada = cadeiaServidor.readLine();

            // apresenta a linha do server no vídeo
            System.out.println("-------------------------------------------------------");
            System.out.println("Servidor retorna o que o cliente digitou em caixa alta:");
            System.out.println("-------------------------------------------------------");
            System.out.println(sentencaModificada);
            System.out.println("-------------------------------------------------------");
            
            
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("***************");
            System.out.println("Digite um CPF: ");
            System.out.println("***************");

            String cpf = br.readLine();

//			Envia estes dados ao server
            saida.writeUTF(cpf);

//			Recebe a resposta do server e imprime em seguida
            boolean resultado = entrada.readBoolean();
            if (resultado) {
                System.out.println("Resposta do Serviror: O CPF: " + cpf + " é válido ");
            } else {
                System.out.println("Resposta do Serviror: O CPF: " + cpf + " é inválido ");
            }

          //  socket.close();

//			
           

        } catch (Exception e) {

        }
    }
}
