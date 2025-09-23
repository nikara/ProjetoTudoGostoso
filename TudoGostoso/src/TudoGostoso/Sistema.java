package TudoGostoso;

import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {

        System.out.println("Projeto Quase tudo gostoso");

        System.out.println("Menu");

        // Finaliza o programa
        char chave = 'X';

        Scanner sc = new Scanner(System.in);

        while (chave == 'X' ) {

            int opcao;

            System.out.println("Escolha uma opção ");
            System.out.println(" 1 - Caterigoria ");
            System.out.println(" 2 - Custo ");
            System.out.println(" 3 - Preparo ");
            System.out.println(" 4 - Utensilio ");
            System.out.println(" 5 - Receita ");
            System.out.println(" 6 - Fechar o Programa ");
            
            int i = sc.nextInt();

            switch (i) {
                case 1:
                System.out.println(" 1 - Adicionar Categoria ");
                System.out.println(" 2 - Listar Categoria ");
                    int x = sc.nextInt();
                    if(x == 1){
                        
                    }else if (x == 2){

                    }


                    
                    break;
                case 2:

                System.out.println(" 1 - Adicionar Custo ");
                System.out.println(" 2 - Listar Custo ");
                    
                    break;
                case 3:
                System.out.println(" 1 - Adicionar Preparo ");
                System.out.println(" 2 - Listar Preparo ");
                    
                    break;
                case 4:
                System.out.println(" 1 - Adicionar Utensilio ");
                System.out.println(" 2 - Listar Utensilio ");
                    
                    break;
                case 5:
                System.out.println(" 1 - Adicionar Receita ");
                System.out.println(" 2 - Listar Receita ");
                    
                    break;
                case 6:

                    chave = 'C';

                    break;
            
                default:
                    break;
            }

            
            
        }
        
        
    }
}
