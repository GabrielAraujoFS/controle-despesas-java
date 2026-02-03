package ProjetoJava;
import java.util.Scanner;
import java.util.ArrayList;
import ProjetoJava.model.Despesa;
import ProjetoJava.services.DespesasService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DespesasService despesasService = new DespesasService();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Menu Principal");
            System.out.println("1-CADASTRAR");
            System.out.println("2-lISTAR");
            System.out.println("3-CALCULAR TOTAL");
            System.out.println("4-Listar despesas por categoria ");
            System.out.println("5-Remover Descrição");
            System.out.println("0-SAIR");
            opcao = scanner.nextInt();
            if (opcao == 1) {
                scanner.nextLine();
                System.out.println("Descrição:");
                String descricao = scanner.nextLine();

                System.out.println("Valor:");
                double valor = scanner.nextDouble();

                scanner.nextLine();
                System.out.println("Categoria:");
                String categoria = scanner.nextLine();

                Despesa novaDespesa = new Despesa(descricao, valor, categoria);

                despesasService.adicionarDespesa(novaDespesa);

                System.out.println("Despesa adicionada com Sucesso!");

            } else if (opcao == 2) {
                if (despesasService.estaVazia()) {
                    System.out.println("Nenhum despesa cadastrada");
                } else {
                    System.out.println("Lista de Despesas");
                    for (Despesa d : despesasService.ListarDespesas()) {
                        System.out.println("Descrição:" + d.getDescricao());
                        System.out.println("Valor:" + d.getValor());
                        System.out.println("Categoria:" + d.getCategoria());
                    }
                }
            } else if (opcao == 3) {
                if (despesasService.estaVazia()) {
                    System.out.println("Nenhuma despesa cadastrada.");
                } else {
                    double total = despesasService.calcularTotal();
                    System.out.println("Total gasto: R$" +  total);
                    if (opcao > 3) {
                        System.out.println("Digite uma Opção Valida!");

                    }
            }
        }
            else if (opcao == 4){
                scanner.nextLine();
                System.out.println("Digite uma categoria:");
                String categoriaBusca = scanner.nextLine();

                ArrayList<Despesa> filtradas = despesasService.listarPorCategoria(categoriaBusca);
                if (filtradas.isEmpty()){
                    System.out.println("Nenhuma despesa encontrada");
                }else {
                    for (Despesa d: filtradas){
                        System.out.println(d.getDescricao()+ "- R$" + d.getValor());

                    }
                }
            } else if (opcao == 5) {
                scanner.nextLine();
                System.out.println("Digite a descrição para apagar:");
                String removerDescricao = scanner.nextLine();
                if (despesasService.removerPorDescricao(removerDescricao)){
                    System.out.println("Descrição removida com sucesso");

                }else {
                    System.out.println("Despesa nao encontrada!");
                }

            } else {
                System.out.println("Saindo...");
        }

    }
 }
}






//SE opção for 1 → cadastrar
//  SE opção for 2 → listar
//  SE opção for 3 → calcular total
//  SE opção for 0 → sair




