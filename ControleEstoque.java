
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ControleEstoque {
    static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("digitacao.txt"));

        while (true) {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    filtrarPorCategoria(scanner);
                    break;
                case 4:
                    ordenarProdutos();
                    break;
                case 5:
                    removerProduto(scanner);
                    break;
                case 6:
                    atualizarPreco(scanner);
                    break;
                case 7:
                    listarComSubtotal();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    static void cadastrarProduto(Scanner sc) {
        String nome = sc.nextLine();
        int qtd = sc.nextInt();
        double preco = sc.nextDouble();
        sc.nextLine();
        String categoria = sc.nextLine();
        int qtdMin = sc.nextInt();
        sc.nextLine();

        produtos.add(new Produto(nome, qtd, preco, categoria, qtdMin));
    }

    static void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    static void filtrarPorCategoria(Scanner sc) {
        String cat = sc.nextLine();
        for (Produto p : produtos) {
            if (p.getCategoria().equalsIgnoreCase(cat)) {
                System.out.println(p);
            }
        }
    }

    static void ordenarProdutos() {
        produtos.sort(Comparator.comparing(Produto::getNomeDescricao));
        System.out.println("Produtos ordenados por nome.");
    }

    static void removerProduto(Scanner sc) {
        String nome = sc.nextLine();
        produtos.removeIf(p -> p.getNomeDescricao().equalsIgnoreCase(nome));
    }

    static void atualizarPreco(Scanner sc) {
        String nome = sc.nextLine();
        double novoPreco = sc.nextDouble();
        sc.nextLine();
        for (Produto p : produtos) {
            if (p.getNomeDescricao().equalsIgnoreCase(nome)) {
                p.setPrecoUnitario(novoPreco);
                break;
            }
        }
    }

    static void listarComSubtotal() {
        Map<String, Double> subtotalPorCategoria = new HashMap<>();
        for (Produto p : produtos) {
            subtotalPorCategoria.put(
                p.getCategoria(),
                subtotalPorCategoria.getOrDefault(p.getCategoria(), 0.0) + p.getSubtotal()
            );
        }
        double totalGeral = 0;
        for (String cat : subtotalPorCategoria.keySet()) {
            System.out.printf("Categoria: %s - Subtotal: R$ %.2f%n", cat, subtotalPorCategoria.get(cat));
            totalGeral += subtotalPorCategoria.get(cat);
        }
        System.out.printf("Total geral: R$ %.2f%n", totalGeral);
    }
}
