import java.util.Scanner;

public class ControleEstoque {
    
    public static String lerTextoNaoNulo(Scanner caixaDeTexto, String mensagem){
        while (true) {
            System.out.println(mensagem);

            String texto = caixaDeTexto.nextLine();

            if (texto != null && !texto.trim().isEmpty()) {
                return texto.trim();
            }
            System.out.println("Entrada inválida, digite um texto não vazio.");
        }
    }

    public static int lerInt(Scanner caixaDetexto, String mensagem, int minPermitido){
        while (true) {
            System.out.println(mensagem);
            String texto = caixaDetexto.nextLine();

            try{
                int valor = Integer.parseInt(texto.trim());

                if (valor < minPermitido) {
                    System.out.println("Valor invádio. O minimo permitido é: " + minPermitido);
                    continue;
                }
                return valor;

            } catch(NumberFormatException e){
                System.out.println("Entrada inváda. Digite um número inteiro(ex: 0, 10, 25, ...)");
            }
        }
    }

    private static double lerDouble(Scanner caixaDetexto, String mensagem, double minPermitido){
        while (true) {
            System.out.println(mensagem);
            String texto = caixaDetexto.nextLine();

            try {
                double valor = Double.parseDouble(texto.trim().replace(",","."));

                if (valor < minPermitido) {
                    System.out.println("Valor inválido. o mínimo permitido é: " + minPermitido);
                    continue;
                } 
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número (ex: 25.50, 11,38...)");
            }
        }
    }

    private static Produto cadastrarProduto(Scanner caixaDetexto, String categoria){

        System.out.println("\n=== Cadastro: " + categoria + "====");

        String nome = lerTextoNaoNulo(caixaDetexto, "Nome do produto(campo obrigatório)");

        double preco = lerDouble(caixaDetexto, "O preço do produto (ex: 25.50 ou 25,50) R$ ", 0.0);

        int quantidade = lerInt(caixaDetexto, "Quantidade em estoque: (ex: número inteiro >=0):", 0);

        return new Produto(nome, categoria, preco, quantidade);
    }

    private static void compararDoisProdutos(Produto a, Produto b){
        System.out.println("\n === Comparação Final ===");

        System.out.println("\n------ Comparação de quantidade de estoque ");

        if (a.getQuantidade() > b.getQuantidade()) {
            System.out.println(a.getNome() + " Tem mais em estoque que " + b.getNome());
        }else if (b.getQuantidade() > a.getQuantidade()){
            System.out.println(b.getNome() + " Tem mais em estoque que " + a.getNome());
        }else {
            System.out.println("Os dois produtos tem a mesma quantidade em estoque ---");
        }

        System.out.println("--- Comparação de valor total em estoque ---");

        double totalA = a.calcularValorEmEstoque();
        double totalB = b.calcularValorEmEstoque();

        if (totalA > totalB) {
            System.out.printf("%s tem maior valor em estoque (R$ %.2f) em comparação com %s%n", a.getNome(), totalA, b.getNome());
        } else if (totalB > totalA) {
            System.out.printf("%s tem maior valor em estoque (R$ %.2f) em comparação com %s%n", b.getNome(), totalB, a.getNome());
        }else{
            System.out.println("os dois produtos possui o mesmo valor em estoque.");
        }

    }

    public static void main(String[] args) {
        Scanner caixaDeTexto = new Scanner(System.in);

        Produto comida1 = cadastrarProduto(caixaDeTexto, "Comida");
        Produto produtoLimpeza1 = cadastrarProduto(caixaDeTexto, "Produto de Limpeza");
        Produto produtoHigienePessoal1 = cadastrarProduto(caixaDeTexto, "Produto Higiene Pessoal");

        System.out.println("\n==== Resumo dos produtos cadastrados ====");

        System.out.println("Produto 1 - Comida");
        comida1.exibirResumo();
        System.out.println("\n");

        System.out.println("Produto 2 - Produto de Limpeza");
        produtoLimpeza1.exibirResumo();
        System.out.println("\n");

        System.out.println("Produto 3 - Produto Higiene Pessoal");
        produtoHigienePessoal1.exibirResumo();

        compararDoisProdutos(comida1, produtoLimpeza1);

        caixaDeTexto.close();
        
    }
}
