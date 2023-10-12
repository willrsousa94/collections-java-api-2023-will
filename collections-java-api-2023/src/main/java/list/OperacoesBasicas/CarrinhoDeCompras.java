package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> comprasList;

    public CarrinhoDeCompras() {
        this.comprasList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        comprasList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensPararemover = new ArrayList<>();
        if(!comprasList.isEmpty()) {
            for (Item t : comprasList) {
                if(t.getNome().equalsIgnoreCase(nome)) {
                    itensPararemover.add(t);
                }
            }
            comprasList.removeAll(itensPararemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calculaValorTotal(){
        double soma = 0;
        for(Item itens : comprasList){
            soma += itens.getPreco() * itens.getQuantidade();
        }

        return soma;
    }

    public boolean exibirItems() {

        for(Item itens  : comprasList){
            System.out.println("Nome: " + itens.getNome() + " Valor: R$" + itens.getPreco() + " Quantidade: " + itens.getQuantidade());
        }

        return false;
    }


    public static void main(String[] args) {

        CarrinhoDeCompras itens = new CarrinhoDeCompras();

        itens.adicionarItem("Leite Italak", 5.4, 2);
        itens.adicionarItem("Açúcar União 1un", 2.4, 10);
        itens.adicionarItem("Café Melita", 14.4, 5);

        System.out.println(itens.calculaValorTotal());
        System.out.println(itens.exibirItems());

    }
}

