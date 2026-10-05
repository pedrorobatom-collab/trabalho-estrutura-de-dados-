import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Produto[] produtos = new Produto[5];

        produtos[0] = new Produto("Mouse", 50.0, StatusProduto.DISPONIVEL);
        produtos[1] = new Produto("Teclado", 120.0, StatusProduto.DISPONIVEL);
        produtos[2] = new Produto("Monitor", 800.0, StatusProduto.ESGOTADO);
        produtos[3] = new Produto("Notebook", 3500.0, StatusProduto.DISPONIVEL);
        produtos[4] = new Produto("Headset", 200.0, StatusProduto.DISPONIVEL);

        Pilha historico = new Pilha(20);

        int opcao;

        do {

            System.out.println("\n===== CATÁLOGO DE PRODUTOS =====");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Buscar produto");
            System.out.println("3 - Ver última busca");
            System.out.println("4 - Remover última busca");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- LISTA DE PRODUTOS ---");

                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do produto: ");
                    String busca = sc.nextLine();

                    boolean encontrado = false;

                    for (Produto produto : produtos) {

                        if (produto.getNome().equalsIgnoreCase(busca)) {

                            System.out.println("\nProduto encontrado:");
                            System.out.println(produto);

                            historico.empilhar(busca);

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    String topo = historico.topo();

                    if (topo == null) {
                        System.out.println("Nenhuma busca registrada.");
                    } else {
                        System.out.println("Última busca: " + topo);
                    }
                    break;

                case 4:
                    String removido = historico.desempilhar();

                    if (removido == null) {
                        System.out.println("Pilha vazia.");
                    } else {
                        System.out.println("Busca removida: " + removido);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}