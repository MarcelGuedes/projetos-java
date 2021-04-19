// Atividade Avaliativa II 
// Aluno: Marcel Guedes Martins
// Disciplina:  Linguagem de programação orientada a objetos 
// Professor: Orlando
// Tutor:  Alfeu
package SistemaFarmacia;

//  ATRIBUTOS DA CLASSE PEDIDO, TODOS SÃO PRIVADOS 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {
private int codigo;
private int codrem;
private int codcli;
private String pagamento;

//  MÉTODOS ACESSORES QUE DÃO ACESSO AOS ATRIBUTOS DA CLASSE PEDIDO 
    /**
     * @return the codigo
     */
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
     * @return the codrem
     */
    public int getCodrem() {
        return codrem;
    }

    /**
     * @param codrem the codrem to set
     */
    public void setCodrem(int codrem) {
        this.codrem = codrem;
    }

    /**
     * @return the codcli
     */
    public int getCodcli() {
        return codcli;
    }

    /**
     * @param codcli the codcli to set
     */
    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }

    /**
     * @return the pagamento
     */
    public String getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
 private static final List<Remedio> listaRemedio = new ArrayList<>();
   private static final List<Cliente> listaCliente = new ArrayList<>();
    private static final List<Pedido> listaPedido = new ArrayList<>();
public void realizaPedido(){
    
     Scanner ler = new Scanner(System.in);
    
     //sub menu Pedido
            // #################################################################
           
              int opcaoV = 0;
              do{
                    menuPedido();
                    opcaoV = ler.nextInt();

                    //Realiza um pedido
                     if (opcaoV == 1){
                    if (Cliente.listaCliente.size() != 0) {
                        if (Remedio.listaRemedio.size() != 0) {
                            System.out.println("Digite o codigo do Pedido");
                            int codped = ler.nextInt();
                            System.out.println("--------------------------------");

                            System.out.println("Lista de clientes");
                            for (Cliente c : Cliente.listaCliente) {
                                System.out.println("Código: " + c.getCodigo() + " Nome: " + c.getNome() + " Endereço: " + c.getEndereco()+ "Fone: " +c.getFone() + " Email: "  + c.getEmail());
                            }
                            System.out.println("--------------------------------");
                            System.out.println("Digite o código do cliente");
                            int codcli = ler.nextInt();
                            System.out.println("--------------------------------");

                            System.out.println("Lista de Remédios");
                            for (Remedio c : Remedio.listaRemedio) {
                                System.out.println("Codigo: " + c.getCodigo() + " Descrição: " + c.getDescricao() +  " Quantidade" + c.getQuantidade() + "Valor" + c.getValor());
                            }
                            System.out.println("--------------------------------");
                            System.out.println("Digite o Codigo do Remédio");
                            int codrem = ler.nextInt();

                            System.out.println("--------------------------------");
                            System.out.println("Digite a Forma de pagamento");
                            String pagamento = ler.next();
                            addPedido(codped, codcli, codrem, pagamento);

                        } else {
                            System.out.println("Não há Remédios Cadastrados");
                        }
                    } else {
                        System.out.println("Não há Clientes Cadastrados");
                    }
                     }
                 //listar  Pedidos
                if (opcaoV == 2){
                    if (Pedido.listaPedido.size()==0){
                        System.out.println("-------------------------");
                        System.out.println("Não há Pedidos realizados");
                        System.out.println("*************************");
                    }else {
                        for (Pedido c : Pedido.listaPedido){
                            for (Cliente cli : Cliente.listaCliente){
                                if (cli.getCodigo()== c.getCodcli()){
                                    for (Remedio rem : Remedio.listaRemedio){
                                        if (rem.getCodigo()== c.getCodrem()){
                                        System.out.println("Codigo do Pedido:  "+c.getCodigo()+" Cliente: "+cli.getNome()+" Medicamento: "+ rem.getDescricao()+ " Quantidade"+ rem.getQuantidade()+ "Forma de Pgto: " + c.getPagamento());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                
                //Excluir uma Pedido
                else if (opcaoV == 3){
                    System.out.println("Excluir um pedido");
                    System.out.print("Digite o Codigo do Pedido: ");
                    int excluir=ler.nextInt();
                    for (Pedido f : Pedido.listaPedido){
                        if (f.getCodigo()==excluir){
                            Pedido.listaPedido.remove(f);
                            System.out.println("O Pedido de codigo "+excluir+" foi excluido com sucesso!");
                            break;
                        }
                    }
                }
                     
                  
       
                       
          

    
}while (opcaoV !=4);
        
} 
    


  // menu Pedido
    public static void menuPedido(){
        System.out.println("");
        System.out.println("SubMenu - Pedido");
        System.out.println("----------------------------");
        System.out.println(" 1 - Realizar um Pedido");
        System.out.println(" 2 - Lista Pedidos");
        System.out.println(" 3 - Excluir uma Pedido");
        System.out.println(" 4 - Retornar ao Menu principal");
        System.out.println("----------------------------");
        System.out.print("Digite a opção desejada: ");
    } 

  //Adicionando um objeto na classe pedido

    public static void  addPedido(int codped, int codcli, int codrem, String pagamento){
        Pedido newPedido = new Pedido();
        newPedido.setCodigo(codped);
        newPedido.setCodcli(codcli);
        newPedido.setCodrem(codrem);
        newPedido.setPagamento(pagamento);
       listaPedido.add(newPedido);
        
    }
}
   
   