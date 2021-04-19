// Atividade Avaliativa II 
// Aluno: Marcel Guedes Martins
// Disciplina:  Linguagem de programação orientada a objetos 
// Professor: Orlando
// Tutor:  Alfeu
package SistemaFarmacia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Farmacia {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in); // POSSIBILITA A ENTRADA DE DADOS 

        //Vamos repetir
        int opcao = 0;

        do {
            menuPrincipal();
            opcao = ler.nextInt();

            if (opcao == 1) {
                int opcaoC = 0;
                //do{               
                Remedio cad1 = new Remedio();
                cad1.cadastraRemedio();
            }

            if (opcao == 2) {
                int opcaoC = 0;

                Cliente cad2 = new Cliente();
                cad2.cadastraCliente();
            }

            if (opcao == 3) {
                int opcaoV = 0;

                Pedido cad3 = new Pedido();
                cad3.realizaPedido();

            }
        } while (opcao != 4);

    }

    // menu principal
    public static void menuPrincipal() {
        System.out.println("");
        System.out.println("Programa de Farmácia");
        System.out.println("----------------------------");
        System.out.println(" 1 - Menu Remédios");
        System.out.println(" 2 - Menu Clientes");
        System.out.println(" 3 - Menu Pedidos");
        System.out.println(" 4 - Sair do Sistema");
        System.out.println("----------------------------");
        System.out.print("Digite a opção desejada: ");
    }

}
