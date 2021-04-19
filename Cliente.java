// Atividade Avaliativa II 
// Aluno: Marcel Guedes Martins
// Disciplina:  Linguagem de programação orientada a objetos 
// Professor: Orlando
// Tutor:  Alfeu
package SistemaFarmacia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cliente {      //
private int codigo;         // 
private String nome;        //    ATRIBUTOS DA CLASSE CLIENTE
private String endereco;    //
private String fone;        //
private String email;       //
    /**
     * @return the codigo                     
     */                                        
  
// MÉTODOS ACESSORES QUE DÃO ACESSO AOS ATRIBUTOS PRIVADOS DA CLASSE CLIENTE

public int getCodigo() {                  
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
 static final List<Cliente> listaCliente = new ArrayList<>();
public void cadastraCliente(){
     Scanner ler = new Scanner(System.in);
   
     //sub menu Cliente
            // #################################################################
            int opcaoC = 0;
            do{
               
                    menuCliente();
                    opcaoC = ler.nextInt();

                    //Cadastra um Cliente
                    if (opcaoC == 1) {
                        System.out.println("Digite o código do Cliente");
                        int codigo = ler.nextInt();
                        System.out.println("Digite o Nome do Cliente");
                        String nome = ler.next();
                        System.out.println("Digite o endereço do Cliente");
                        String endereco = ler.next();
                        System.out.println("Digite o fone do Cliente");
                        String fone = ler.next();
                        System.out.println("Digite o email do Cliente");
                        String email = ler.next();
                        addCliente(codigo, nome, endereco, fone, email);
                    } 
                     //listar os Clientes
                    
                    else if (opcaoC == 2) {
                        if (Cliente.listaCliente.size() == 0) {
                            System.out.println("-------------------------");
                            System.out.println("Não há Clientes Cadastrados");
                            System.out.println("-------------------------");
                        } else {
                            for (Cliente c : Cliente.listaCliente) {
                                System.out.println("Codigo: " + c.getCodigo() + " Nome: " + c.getNome() + " Endereço: " + c.getEndereco() + " Fone: " + c.getFone() + " E-mail: " + c.getEmail());
                            }
                        }
                    } //Excluir um Cliente
                    else if (opcaoC == 3) {
                        System.out.println("Excluir um Cliente");
                        System.out.println("Digite o código do Cliente: ");
                        int excluir = ler.nextInt();
                        for (Cliente f : Cliente.listaCliente) {
                            if (f.getCodigo() == excluir) {
                                listaCliente.remove(f);
                                System.out.println("O Cliente de código " + excluir + " foi excluido com sucesso!");
                                break;
                            }
                        }
                    }
            }while (opcaoC !=4);
            }
    

  


  // menu Cliente
    public static void menuCliente(){
        System.out.println("");
        System.out.println("SubMenu - Cliente");
        System.out.println("----------------------------");
        System.out.println(" 1 - Cadastrar Clientes");
        System.out.println(" 2 - Lista os Clientes");
        System.out.println(" 3 - Excluir um Cliente");
        System.out.println(" 4 - Retornar ao Menu principal");
        System.out.println("----------------------------");
        System.out.print("Digite a opção desejada: ");
    }

  
//Adicionando um objeto na classe Cliente
    public static void addCliente(int codigo, String nome, String endereco, String fone, String email){
        Cliente newCliente = new Cliente();
        newCliente.setCodigo(codigo);
        newCliente.setNome(nome);
        newCliente.setEndereco(endereco);
        newCliente.setFone(fone);
        newCliente.setEmail(email);        
        listaCliente.add(newCliente);
    }
}
  //  private void addCliente(int codigo, String nome, String endereco, String fone, String email) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }
//}