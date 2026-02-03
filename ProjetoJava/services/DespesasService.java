package ProjetoJava.services;
import java.util.ArrayList;
import ProjetoJava.model.Despesa;

public class DespesasService {
    private ArrayList<Despesa> despesas = new ArrayList<>();

    public void adicionarDespesa(Despesa despesa){
        despesas.add(despesa);
    }

    public ArrayList<Despesa> ListarDespesas(){
        return despesas;

    }
    public boolean estaVazia(){
        return despesas.isEmpty();
    }
    public double calcularTotal(){
        double calculoTotal = 0;
        for (Despesa d: despesas){
            calculoTotal += d.getValor();

        }
        return calculoTotal;

    }

    public ArrayList<Despesa> listarPorCategoria(String categoria) {
        ArrayList<Despesa> resultado = new ArrayList<>();
        for (Despesa d : despesas) {
            if (d.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(d);
            }
        }
        return resultado;
    }
        public boolean removerPorDescricao(String descricao){
            for(int i= 0; i< despesas.size(); i++){

                Despesa d = despesas.get(i);
                if (d.getDescricao().equalsIgnoreCase(descricao)){
                    despesas.remove(i);
                    return true;
                }
        }
            return false;
    }
}
