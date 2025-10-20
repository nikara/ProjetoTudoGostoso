package TudoGostoso;

import java.util.ArrayList;
import java.util.Scanner;
import TudoGostoso.model.*;

public class Sistema {
    public static void main(String[] args) {

        // #region Instancia dos objetos em ArrayList

        ArrayList<Categoria> categoriaArray = new ArrayList<Categoria>();
        ArrayList<Custo> custoArray = new ArrayList<Custo>();
        ArrayList<Preparo> preparoArray = new ArrayList<Preparo>();
        ArrayList<Utensilio> utensilioArray = new ArrayList<Utensilio>();

        ArrayList<Receita> receitaArray = new ArrayList<Receita>();
        ArrayList<Usuario> usuarioArray = new ArrayList<Usuario>();

        // #endregion

        // Inicio do Programa

        System.out.println("Projeto Quase tudo gostoso");

        // Variaveis globais
        // variavel de controle do while loop
        Boolean chave = true;

        // Instancia o Scanner
        Scanner sc = new Scanner(System.in);

        // #region Criação de instâncias de Administrador e Consumidor usando a herança de Usuario
        Administrador admin = new Administrador(1,"Admin Master","admin@email.com", "01/01/1990", 12345678, "Masculino", "senhaAdmin", "saltAdmin", "Sim", "uuidAdmin");
    Consumidor consumidor = new Consumidor(2, "Maria", "maria@email.com", "05/05/1995", 87654321, "Feminino", "senhaMaria", "saltMaria", "Nao", "uuidConsumidor1");
        

        usuarioArray.add(admin);
        usuarioArray.add(consumidor);

        // #endregion

        // #region Menu
        // Loop que mantém o programa ativo

        while (chave) {

            System.out.println("--------------------Menu--------------------");

            System.out.println("Escolha uma opção");
            System.out.println(" 1 - Construir Receita");
            System.out.println(" 2 - Administrador");
            System.out.println(" 3 - Consumidor");
            System.out.println(" 4 - Fechar Programa");

            int opcao = sc.nextInt();

            // #region
            // Administrador e Consumidor podem construir e apagar receitas mas apenas
            // administrador pode apagar receitas de outros consumidores
            // Abre o Menu para construir receita

            if (opcao == 1) {
                while (chave) {

                    // #region
                    System.out.println("Construa sua receita");
                    System.out.println(" 1 - Caterigoria");
                    System.out.println(" 2 - Custo");
                    System.out.println(" 3 - Preparo");
                    System.out.println(" 4 - Utensilio");
                    System.out.println(" 5 - Receita");
                    System.out.println(" 6 - Fechar o Programa");

                    System.out.println(" Escolhar uma Opção");
                    opcao = 0;
                    opcao = sc.nextInt();
                    // #endregion

                    // #region
                    switch (opcao) {

                        case 1:
                            // #region
                            // Categoria
                            System.out.println(" 1 - Adicionar Categoria ");
                            System.out.println(" 2 - Listar Categoria ");
                            System.out.println(" 3 - Escolher elemento");
                            int x = sc.nextInt();
                            if (x == 1) {

                                System.out.println("Digite o ID");
                                int ID = sc.nextInt();

                                System.out.println("Digite a Categoria");
                                String categoriaString = sc.next();

                                System.out.println("Escolha o Status 1 para Ativo 0 para Inativo");
                                int CondicaoStatus = sc.nextInt();

                                Boolean StatusBool;

                                if (CondicaoStatus == 1) {
                                    StatusBool = true;
                                } else {
                                    StatusBool = false;
                                }

                                Categoria categoria = new Categoria(ID, categoriaString, StatusBool);
                                categoriaArray.add(categoria);

                            } else if (x == 2) {
                                for (Categoria c : categoriaArray) {
                                    System.out.println(c);
                                }
                            } else if (x == 3) {
                                System.out.println("Escolha um do elementos");
                                for (int t = 0; t < categoriaArray.size(); t++) {
                                    System.out.println(
                                            "O indice do elemento e " + t + " o elemento e" + categoriaArray.get(t));
                                }
                            }

                            x = 0;

                            break;
                        // #endregion

                        case 2:
                            // #region

                            // Custo
                            System.out.println(" 1 - Adicionar Custo ");
                            System.out.println(" 2 - Listar Custo ");
                            x = sc.nextInt();
                            if (x == 1) {
                                System.out.println("Digite o ID");

                                int ID = sc.nextInt();

                                // Para consumir o enter
                                sc.nextLine();

                                System.out.println("Digite o Custo");

                                String custoString = sc.nextLine();

                                Custo custo = new Custo(ID, custoString);
                                custoArray.add(custo);

                            } else if (x == 2) {
                                for (Custo custo : custoArray) {
                                    System.out.println(custo);
                                }

                            }
                            x = 0;

                            break;
                        // #endregion

                        case 3:
                            // #region

                            // Preparo
                            System.out.println(" 1 - Adicionar Preparo ");
                            System.out.println(" 2 - Listar Preparo ");
                            x = sc.nextInt();
                            if (x == 1) {

                                System.out.println("Digite o ID");
                                int ID = sc.nextInt();

                                // Para consumir o enter
                                sc.nextLine();

                                System.out.println("Digite o Modo de Preparo");
                                String modoDePreString = sc.nextLine();

                                System.out.println("Digite o Url do Video");
                                String urlString = sc.nextLine();

                                System.out.println("Digite o Tempo de preparo");
                                String tempoDePreparo = sc.nextLine();

                                Preparo preparo = new Preparo(ID, modoDePreString, urlString, tempoDePreparo);
                                preparoArray.add(preparo);
                            } else if (x == 2) {
                                for (Preparo preparo : preparoArray) {
                                    System.out.println(preparo);
                                }
                            }

                            x = 0;

                            break;
                        // #endregion

                        case 4:
                            // #region

                            // Utensilio
                            System.out.println(" 1 - Adicionar Utensilio ");
                            System.out.println(" 2 - Listar Utensilio ");
                            x = sc.nextInt();
                            if (x == 1) {
                                System.out.println("Digite o ID");
                                int ID = sc.nextInt();

                                // Para consumir o enter
                                sc.nextLine();

                                System.out.println("Digite o Utensilio");
                                String utensilioString = sc.nextLine();

                                Utensilio utensilio = new Utensilio(ID, utensilioString);
                                utensilioArray.add(utensilio);
                            } else if (x == 2) {
                                for (Utensilio utensilio : utensilioArray) {
                                    System.out.println(utensilio);
                                }
                            }

                            x = 0;

                            break;
                        // #endregion

                        case 5:
                            // #region
                            // Receita
                            System.out.println(" 1 - Adicionar Receita ");
                            System.out.println(" 2 - Listar Receita ");
                            x = sc.nextInt();
                            if (x == 1) {
                                System.out.println("Digite o ID");
                                int ID = sc.nextInt();

                                // Para consumir o enter
                                sc.nextLine();

                                System.out.println("Digite o titulo");
                                String titulo = sc.nextLine();
                                System.out.println("Digite a Descrição");
                                String descricao = sc.nextLine();
                                System.out.println("Digite o caminho da Imagem");
                                String imagem = sc.nextLine();

                                // Escolhendo os objetos da receita
                                Boolean chaveDois = true;
                                Categoria categoriaEscolhido = new Categoria();
                                Custo custoEscolhido = new Custo();
                                Preparo preparoEscolhido = new Preparo();
                                Utensilio utensilioEscolhido = new Utensilio();

                                // #region Loop para escolher os elementos da receita
                                while (chaveDois) {
                                    System.out.println("Escolha os elementos da receita");
                                    System.out.println(" 1 - Caterigoria");
                                    System.out.println(" 2 - Custo");
                                    System.out.println(" 3 - Preparo");
                                    System.out.println(" 4 - Utensilio");
                                    System.out.println(" 5 - Sair do menu");
                                    opcao = 0;
                                    opcao = sc.nextInt();

                                    // #region Estrutura de Condição
                                    if (opcao == 1) { // Categoria
                                        for (Categoria categoria : categoriaArray) {
                                            System.out.println(categoria);
                                            System.out.println("Escolha uma das Categorias");
                                        }
                                        opcao = 0;
                                        opcao = sc.nextInt();
                                        categoriaEscolhido = categoriaArray.get(opcao-1);

                                    } else if (opcao == 2) { // Custo
                                        for (Custo custo : custoArray) {
                                            System.out.println(custo);
                                            System.out.println("Escolha uma das Categorias");
                                        }
                                        opcao = 0;
                                        opcao = sc.nextInt();
                                        custoEscolhido = custoArray.get(opcao-1);

                                    } else if (opcao == 3) { // Preparo
                                        for (Preparo preparo : preparoArray) {
                                            System.out.println(preparo);
                                            System.out.println("Escolha uma das Categorias");
                                        }
                                        opcao = 0;
                                        opcao = sc.nextInt();
                                        preparoEscolhido = preparoArray.get(opcao-1);

                                    } else if (opcao == 4) { // Utensilio
                                        for (Utensilio utensilio : utensilioArray) {
                                            System.out.println(utensilio);
                                            System.out.println("Escolha uma das Categorias");
                                        }
                                        ;
                                        opcao = 0;
                                        opcao = sc.nextInt();
                                        utensilioEscolhido = utensilioArray.get(opcao-1);

                                    } else if (opcao == 5) { // Sair do menu
                                        chaveDois = false;
                                    } else {
                                        System.out.println("Opção errada tente novamente");
                                    }
                                    // #endregion
                                }
                                // #endregion

                                Receita receita = new Receita(ID, titulo, descricao, imagem, custoEscolhido,
                                        preparoEscolhido, categoriaEscolhido, utensilioEscolhido);
                                receitaArray.add(receita);

                                System.out.println("Receita Adicionada" + receita.toString());

                            } else if (x == 2) {
                                for (Receita r : receitaArray)
                                    System.out.println(r);
                            }

                            x = 0;

                            break;
                        // #endregion

                        case 6:
                            // #region

                            chave = false;
                            System.out.println("Encerrando o programa...");
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                        // #endregion
                    }
                    ;
                }
                ;

            }
            ;
            // #endregion

            // #region
            // 
            if (opcao == 2) {

            }
            ;
            // #endregion

            // #region
            // Apenas o UsuarioMaster e os Administradores podem manter Consumidores
            if (opcao == 3) {

            }
            ;
            // #endregion

        }
        // #endregion
        sc.close();
    }
}
