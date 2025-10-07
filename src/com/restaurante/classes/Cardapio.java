package com.restaurante.classes;
import java.util.ArrayList;
import java.util.List;

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

            if(produto.getCodigoItem().equals(codigoItem)){
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
            this.cardapioRestaurante.get(indiceItem).setStatusItem(status);
        }
    }

}
