package ProjetoJava.model;

public class Despesa {
    private String descricao;
    private double valor;
    private String categoria;

    public Despesa(){

    }
    public Despesa(String descricao, double valor, String categoria){
        super();
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;


    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }
}


