package com.restaurante.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cardapio {
    private List<Produto> cardapioRestaurante;

    public Cardapio() {
        this.cardapioRestaurante = new ArrayList<>();
    }

    public void addItem(Produto prato){
        this.cardapioRestaurante.add(prato);
    }

    public void removerItem(Produto prato) {
        // Verifica se o prato é diferente de nulo, para então remover
        if(prato != null) {
            this.cardapioRestaurante.remove(prato);
        }
    }

    public List<Produto> getCardapioRestaurante() {
        return cardapioRestaurante;
    }

    // Busca o item de acordo com o codigo adicionado
    // **(Depois, aprender sobre try-catch e pegar os erros possíveis)**
    public int buscarItem(String codigoItem) {
        for(int i = 0; i < this.cardapioRestaurante.size(); i++) {
            Produto produto = this.cardapioRestaurante.get(i);

            if(produto.getCodigoProduto().equals(codigoItem)){
                return i;
            }
        }
        return -1;
    }

    // Substitui o status do item pelo status colocado como parâmetro
    // (Pode ser usado para quando um produto estiver fora do estoque)
    public void atualizarDisponibilidadeItem(String codigo, boolean status){
        int indiceItem = buscarItem(codigo);
        if(indiceItem != -1) {
            this.cardapioRestaurante.get(indiceItem).setStatusProduto(StatusProduto.DISPONIVEL);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Cardápio\n\n");
        sb.append("Entradas: \n");
        for (Produto entrada : cardapioRestaurante) {
            if (Objects.equals(cardapioRestaurante.get(buscarItem(entrada.getCodigoProduto())).getCategoriaProduto(), "Entrada")) {
                sb.append(String.format("%-30s | Preço: %-30s\n",
                        entrada,
                        entrada.getPrecoProduto()));
            }
        }

        sb.append("\nPratos principais: \n");
        for (Produto prato : cardapioRestaurante) {
            if (Objects.equals(cardapioRestaurante.get(buscarItem(prato.getCodigoProduto())).getCategoriaProduto(), "Prato Principal")) {
                sb.append(String.format("%-30s | Preço: %-30s\n",
                        prato,
                        prato.getPrecoProduto()));
            }
        }

        sb.append("\nSobremesas: \n");
        for (Produto sobremesa : cardapioRestaurante) {
            if (Objects.equals(cardapioRestaurante.get(buscarItem(sobremesa.getCodigoProduto())).getCategoriaProduto(), "Sobremesa")) {
                sb.append(String.format("%-30s | Preço: %-30s\n",
                        sobremesa,
                        sobremesa.getPrecoProduto()));
            }
        }

        sb.append("\nBebidas: \n");
        for (Produto bebida : cardapioRestaurante) {
            if (Objects.equals(cardapioRestaurante.get(buscarItem(bebida.getCodigoProduto())).getCategoriaProduto(), "Bebida")) {
                sb.append(String.format("%-30s | Preço: %-30s\n",
                        bebida,
                        bebida.getPrecoProduto()));
            }
        }

        return sb.toString();
    }
}





