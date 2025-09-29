package TudoGostoso;


import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {

        //Instancia dos objetos em ArrayList

        ArrayList<Categoria> categoriaArray = new ArrayList<Categoria>();
        ArrayList<Custo> custoArray = new ArrayList<Custo>();
        ArrayList<Preparo> preparoArray = new ArrayList<Preparo>();
        ArrayList<Utensilio> utensilioArray = new ArrayList<Utensilio>();
        ArrayList<Receita> receitaArray = new ArrayList<Receita>(); 

        System.out.println("Projeto Quase tudo gostoso");

        System.out.println("Menu");

        // Finaliza o programa
        char chave = 'X';

        Scanner sc = new Scanner(System.in);



        while (chave == 'X' ) {

        

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
                
                //Categoria
                System.out.println(" 1 - Adicionar Categoria ");
                System.out.println(" 2 - Listar Categoria ");
                    int x = sc.nextInt();
                    if(x == 1){
                        
                        System.out.println("Digite o ID");
                        int ID = sc.nextInt();
                        
                        System.out.println("Digite a Categoria");
                        String categoriaString = sc.next();
                        
                        System.out.println("Escolha o Status 1 para Ativo 0 para Inativo");
                        int CondicaoStatus = sc.nextInt();
                        
                        Boolean StatusBool;
                        
                        if (CondicaoStatus == 1){
                            StatusBool = true;
                        }else{
                            StatusBool = false;
                        }

                        Categoria categoria = new Categoria(ID, categoriaString, StatusBool);
                        categoriaArray.add(categoria);

                    }else if (x == 2){
                        for( Categoria c : categoriaArray){
                            System.out.println(c);
                        }

                    }

                    x = 0;

                    break;
                case 2:

                // Custo
                System.out.println(" 1 - Adicionar Custo ");
                System.out.println(" 2 - Listar Custo ");
                    x = sc.nextInt();
                    if(x == 1){
                        System.out.println("Digite o ID");
                        
                        int ID = sc.nextInt();

                        // Para consumir o enter 
                        sc.nextLine();

                        System.out.println("Digite o Custo");

                        String custoString = sc.nextLine();

                        Custo custo = new Custo(ID, custoString);
                        custoArray.add(custo);

                    }else if (x == 2){
                        for (Custo custo : custoArray) {
                            System.out.println(custo);
                        }

                    }
                    x = 0;

                    break;
                case 3:

                //Preparo
                System.out.println(" 1 - Adicionar Preparo ");
                System.out.println(" 2 - Listar Preparo ");
                    x = sc.nextInt();
                    if(x == 1){

                        System.out.println("Digite o ID");
                        int ID = sc.nextInt();

                        // Para consumir o enter 
                        sc.nextLine();

                        System.out.println("Digite o Modo de Preparo");
                        String modoDePreString = sc.nextLine();


                        System.out.println("Digite o Url do Video");
                        String urlString = sc.nextLine();


                        System.out.println("Digite o Tempo de preparo");
                        int tempoDePreparo = sc.nextInt();

                        // Para consumir o enter 
                        sc.nextLine();

                        Preparo preparo = new Preparo(ID, modoDePreString, urlString, tempoDePreparo);
                        preparoArray.add(preparo);
                    }else if (x == 2){
                        for (Preparo preparo : preparoArray) {
                            System.out.println(preparo);
                        }
                    }

                    x = 0;

                    break;
                case 4:

                // Utensilio
                System.out.println(" 1 - Adicionar Utensilio ");
                System.out.println(" 2 - Listar Utensilio ");
                    x = sc.nextInt();
                    if(x == 1){
                        System.out.println("Digite o ID");
                        int ID = sc.nextInt();

                        // Para consumir o enter 
                        sc.nextLine();

                        System.out.println("Digite o Utensilio");
                        String utensilioString = sc.nextLine();

                        Utensilio utensilio = new Utensilio(ID, utensilioString);
                        utensilioArray.add(utensilio);
                    }else if (x == 2){
                        for (Utensilio utensilio : utensilioArray){
                            System.out.println(utensilio);
                        }
                    }

                    x = 0;
                    
                    break;
                case 5:
                // Receita
                System.out.println(" 1 - Adicionar Receita ");
                System.out.println(" 2 - Listar Receita ");
                x = sc.nextInt();
                if(x == 1){
                    System.out.println("Digite o ID");
                        int ID = sc.nextInt();
                        System.out.println("Digite o titulo");
                        String titulo = sc.nextLine();
                        System.out.println("Digite a Descrição");
                        String descricao = sc.nextLine();
                        System.out.println("Digite o caminho da Imagem");
                        String imagem = sc.nextLine();


                    Receita receita = new Receita(ID, titulo, descricao, imagem, custoArray, categoriaArray, preparoArray, utensilioArray);
                    receitaArray.add(receita);

                    System.out.println("Receita Adicionada");

                }else if(x == 2){
                    for (Receita r : receitaArray) System.out.println(r);
                }
                
                x = 0;
                    
                    break;
                case 6:

                    chave = 'C';
                    System.out.println("Encerrando o programa...");
                    break;
            
                default:
                System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        sc.close();
    }
}
