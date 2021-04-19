// Atividade Avaliativa II 
// Aluno: Marcel Guedes Martins
// Disciplina:  Linguagem de programação orientada a objetos 
// Professor: Orlando
// Tutor:  Alfeu
package SistemaFarmacia;

//  ATRIBUTOS DA CLASSE REMÉDIO, TODOS SÃO PRIVADOS 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Remedio {
 private int codigo;
    private String descricao;
    private int quantidade;
    private int valor;    
    
    
    //  MÉTODOS ACESSORES QUE DÃO ACESSO AOS ATRIBUTOS DA CLASSE REMÉDIO
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

  static final List<Remedio> listaRemedio = new ArrayList<>();
    private static final List<Cliente> listaCliente = new ArrayList<>();
    private static final List<Pedido> listaPedido = new ArrayList<>();
    public void cadastraRemedio (){
       
       Scanner ler = new Scanner(System.in);
    
       
      
       //sub menu Remédio
       int opcaoC = 0;
           
               do{
             
                   menuRemedio();
    opcaoC = ler.nextInt();

                    //Cadastra um Remédio
                    if (opcaoC == 1) { // A OPÇÃO 1 TRATA DO CADASTRO DO SUBMENU DE REMÉDIO
                        // System.out.println("Digite o codigo do Remédio");
                        System.out.println("Digite o código do Remédio");
                        int codigo = ler.nextInt();
                        System.out.println("Digite a descrição do Remédio");
                        String descricao = ler.next();
                        System.out.println("Digite o valor do Remédio");
                        int valor = ler.nextInt();
                        addRemedio(codigo, descricao, valor);
                    }
                    //listar os Remédios
                    else if (opcaoC == 2) {
                        if (Remedio.listaRemedio.size() == 0) {
                            System.out.println("-------------------------");
                            System.out.println("Não há Remédios Cadastrados");
                            System.out.println("-------------------------");
                        } else {
                            for (Remedio c : Remedio.listaRemedio) {
                                System.out.println("Codigo: " + c.getCodigo() + " descricao: " + c.getDescricao() +  " valor: " + c.getValor());
                            }
                        }
                    } //Excluir um Remedio
                    else if (opcaoC == 3) {
                        System.out.println("Excluir um Remédio");
                        System.out.print("Digite o codigo do Remédio: ");
                        int excluir = ler.nextInt();
                        for (Remedio f : Remedio.listaRemedio) {
                            if (f.getCodigo() == excluir) {
                                Remedio.listaRemedio.remove(f);
                                System.out.println("O Remédio de codigo " + excluir + " foi excluido com sucesso!");
                                break;
                            }
                        }
                    }

} while (opcaoC !=4);
            }

    





 // menu Remédio
    public static void menuRemedio(){
        System.out.println("");
        System.out.println("SubMenu - Remedio");
        System.out.println("----------------------------");
        System.out.println(" 1 - Cadastrar Remedio");
        System.out.println(" 2 - Lista os Remedios");
        System.out.println(" 3 - Excluir um Remedio");
        System.out.println(" 4 - Retornar ao Menu principal");
        System.out.println("----------------------------");
        System.out.print("Digite a opção desejada: ");
    }

 //Adicionando um objeto na classe remedio
    public static void addRemedio(int codigo, String descricao, int valor){
        Remedio newRemedio = new Remedio();
        newRemedio.setCodigo(codigo);
        newRemedio.setDescricao(descricao);
       
        newRemedio.setValor(valor);
        listaRemedio.add(newRemedio);
    }
}