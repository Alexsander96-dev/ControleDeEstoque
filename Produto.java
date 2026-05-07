// Classe Mae
public class Produto {

    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;

    //Construtor
    public Produto(String nome, String categoria, double preco, int quantidade){
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        setQuantidade(quantidade);
    }

    //Regra de Negócio
    public void setQuantidade(int quantidade){
        if (quantidade < 0) {
            this.quantidade = 0;
        }else{
            this.quantidade = quantidade; 
        }
    }

    // metodo para saber se a quantidade for += 0 esta disponivel
    public boolean estaDisponivel(){
        return quantidade > 0;
    }

    public String getStatusEstoque(){
        if(quantidade == 0 ) return "Sem estoque";

        if(quantidade <= 5) return "Estoque Baixo";

        if(quantidade <= 20) return "Estoque Normal";

        return "Estoque Alto";
    }

    public double calcularValorEmEstoque(){
        return preco * quantidade;
    }

    public String getNome(){
       return nome;
    }

    public String getCategoria(){
        return categoria;
    }

    public double getPreco(){
        return preco;
    }

    public int getQuantidade(){
        return quantidade;
    }


    public void exibirResumo(){
        System.out.println("Categoria: " + categoria);

        System.out.println("Produto: " + nome);

        System.out.printf("Preço: R$ %.2f\n", preco);

        System.out.println("Quantidade: " + quantidade);

        System.out.println("Disponivel: " + (estaDisponivel() ? "Sim" : "Não"));

        System.out.println("Status estoque: " + getStatusEstoque() );

        System.out.printf("Valor Total em Estoque: R$ %.2f\n", calcularValorEmEstoque());


    }

}
