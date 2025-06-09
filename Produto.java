
public class Produto {
    private String nomeDescricao;
    private int qtdEstoque;
    private double precoUnitario;
    private String categoria;
    private int qtdMinima;

    public Produto(String nomeDescricao, int qtdEstoque, double precoUnitario, String categoria, int qtdMinima) {
        this.nomeDescricao = nomeDescricao;
        this.qtdEstoque = qtdEstoque;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
        this.qtdMinima = qtdMinima;
    }

    public String getNomeDescricao() {
        return nomeDescricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public double getSubtotal() {
        return qtdEstoque * precoUnitario;
    }

    @Override
    public String toString() {
        return nomeDescricao + " | Estoque: " + qtdEstoque + " | Preço: R$" + precoUnitario + " | Categoria: " + categoria;
    }
}
