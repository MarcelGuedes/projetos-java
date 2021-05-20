
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MGM_Servidor {

    private static Socket socket;
//	Canal de comunicação ou uma tomada 
    private static ServerSocket server;
//	O server socket permite criar e guardar as conexões
    private static DataInputStream entrada;
//	Entrada de dados no server
    private static DataOutputStream saida;
//	Saida de dados ...

    public static void main(String[] args) {

        String clienteSentenca;
        String sentencaCapturada;
        try {
//			Criar porta de recepção
            server = new ServerSocket(6789);
            System.out.println("***************************************");
            System.out.println("Servidor aguardando conexão do cliente ");
            System.out.println("***************************************");
            System.out.println("-------------------------------------------");
            System.out.println("Servidor do aluno Marcel inciado porta 6789");
            System.out.println("-------------------------------------------");
            // espera conexão de algum cliente
            
            while (true) {
                socket = server.accept();
                
                // pega o ip de quem conectou  
                System.out.println("Cliente do ip " + socket.getInetAddress().getHostAddress() + " conectou ");   

                // cria streams de entrada e saida com o cliente que chegou
                // cria streams de entrada e saida com o cliente que chegou
                BufferedReader cadeiaCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream servidorParaCliente = new DataOutputStream(socket.getOutputStream());

                // lê uma linha do cliente
                clienteSentenca = cadeiaCliente.readLine();
                System.out.println("Mensagem do CLiente: " + '\n' + clienteSentenca);

                // transforma a linha em maiúsculas
                sentencaCapturada = clienteSentenca.toUpperCase() + '\n';
                // envia a linha maiúscula para o cliente
                servidorParaCliente.writeBytes(sentencaCapturada);

//			Criar fluxos (entrada-saída)
                entrada = new DataInputStream(socket.getInputStream());

                saida = new DataOutputStream(socket.getOutputStream());

//			Recebimento do valor (String cpf)
                String cpf = entrada.readUTF();
                System.out.println("CPF do Cliente: " + cpf);
                System.out.println("Servidor aguardando uma nova conexão");
//			Processamento do valor
                boolean resultado = false;
//Verificação do cpf. Regras:
//Considere d como digito/ d1 = 1º digito - d2 = 2º digito e assim por diante
//d1.10 + d2.9 + d3.8 + d4.7 + d5.6 + d6.5 + d7.4 + d8.3 + d9.2 = x

// Há exceções: os cpfs invalidos 111.111.111-11, 222.222.222-22 e assim por diante,
//segundo a fórmula, são válidos. Contudo, todos são inválidos.
//O código abaixo resolve este problema
                boolean validCPF = false;

                for (int i = 1; i < 11; i++) {
                    if (cpf.charAt(i) != cpf.charAt(i - 1)) {
                        validCPF = true;
                        break;
                    }
                }
//			
                if (cpf.length() == 11 && validCPF == true) {
                    int val1;
                    val1 = 0;
                    int n;
                    n = 10;
                    int valor;
                    for (int i = 0; i < 9; i++) {
                        valor = Integer.parseInt("" + cpf.charAt(i));
//                     O valor vem em char, o Integer.parseInt(), converte String em inteiro
//                     quando eu adiciono "" vira uma String ....
                        val1 = val1 + valor * n;
                        n = n - 1;
                    }

                    int digitoVal1 = Integer.parseInt("" + cpf.charAt(9));
//                  Começa no zero cpf.charAt(0) = 1 digito

                    // Explicar isso ????
                    if (val1 * 10 % 11 == digitoVal1) {
                        int val2 = 0;
                        n = 11;

                        for (int i = 0; i < 10; i++) {
                            valor = Integer.parseInt("" + cpf.charAt(i));
                            val2 = val2 + valor * n;
                            n = n - 1;
                        }

                        int digitoVal2 = Integer.parseInt("" + cpf.charAt(10));

                        if (val2 * 10 % 11 == digitoVal2) {
                            resultado = true;
                        }
                    }
                }

//      	Envio dos dados para o cliente
                saida.writeBoolean(resultado);
              // System.out.println("O CPF digitado é: " + resultado);
                //socket.close();
            }

        } catch (Exception e) {

        }
    }
}
