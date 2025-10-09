package com.restaurante.main;
import com.restaurante.classes.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Criação de classes de usuário:
        Usuario garcom1 = new Garcom("Jefinho",
                "123.456.789-00",
                "jefinhobala@gmail.com",
                "11 94002-8922");
        ((Garcom) garcom1).addHabilidadesGarcom("Ótimo atendimento");
        ((Garcom) garcom1).addHabilidadesGarcom("Sabe carregar a bandeja muito bem");

        Usuario chefe1 = new Chef("Bob",
                "456.123.789-18",
                "esponjadomar@gmail.com",
                "81 92377-6535");

        Usuario cliente1 = new Cliente("Cleiton",
                "987.654.321-01",
                "cleitonrasta@gmail.com",
                "21 99145-7822");
        Usuario cliente2 = new Cliente("Júnio",
                "789.156.342-78",
                "junindabike123@gmail.com",
                "11 94567-8911");
        Usuario cliente3 = new Cliente("Webert",
                "234.156.789-12",
                "naolavoope@gmail.com",
                "11 92347-8119");

        ((Cliente) cliente3).addAlergia("Anfíbios no geral...");

        // Criação das mesas:
        StatusMesa statusMesaSkol = StatusMesa.LIVRE;
        StatusMesa statusMesaSchin = StatusMesa.LIVRE;
        Mesa mesaskol = new Mesa(10,
                statusMesaSkol,
                4);
        Mesa mesaschin = new Mesa(13,
                statusMesaSchin,
                4);

        // Criação dos ClienteMesa:
        ClienteMesa clienteMesaJefinho = new ClienteMesa((Cliente) cliente1, mesaskol);
        ClienteMesa clienteMesaJunio = new ClienteMesa((Cliente) cliente2, mesaskol);
        mesaskol.addNumeroUso();

        ClienteMesa clienteMesaCleber = new ClienteMesa((Cliente) cliente3, mesaschin);
        mesaschin.addNumeroUso();

        // Criação do Cardapio geral:

        Cardapio cardapio = new Cardapio();

        // Criação dos produtos:
        StatusProduto statusFileMignon = StatusProduto.DISPONIVEL;
        Produto fileMignon = new Produto("Filé Mignon",
                "Um gostoso filé",
                56.99,
                CategoriaProduto.PRINCIPAL,
                statusFileMignon,
                "001");

        StatusProduto statusSorvete = StatusProduto.DISPONIVEL;
        Produto sorvete = new Produto("Sorvete",
                "Um sorvete geladinho",
                5.99,
                CategoriaProduto.SOBREMESA,
                statusSorvete,
                "005");

        StatusProduto statusCocaCola = StatusProduto.DISPONIVEL;
        Produto cocaCola = new Produto("Coca-Cola",
                "Coquinha geladinha",
                9.99,
                CategoriaProduto.BEBIDA,
                statusCocaCola,
                "069");


        // Adicionando especialidade no chefe:*
        ((Chef) chefe1).addPratoEspecialidade(fileMignon);

        // Colocando os itens no cardápio:

        cardapio.addItem(fileMignon);
        cardapio.addItem(sorvete);
        cardapio.addItem(cocaCola);

        // Criando item venda:

        ItemVenda vendaFile = new ItemVenda(fileMignon, 2, "Picanha ao invés de filé.");

        // Criando pedido:

        Pedido pedidoJefinho = new Pedido(clienteMesaJefinho,
                (Garcom) garcom1,
                (Chef) chefe1,
                LocalDate.of(2025, 10, 1));

        pedidoJefinho.addItemPedido(vendaFile, vendaFile.getQuantidade(), vendaFile.getObservacaoPedido());

        // Criando o pagamento:

        Pagamento pagamentoFile = new Pagamento(pedidoJefinho);
        pagamentoFile.pagarPedido(pedidoJefinho);

        // Dando toString em tudo que for possível:

        System.out.println(garcom1.toString());
        System.out.println(chefe1.toString());
        System.out.println();
        System.out.println(cliente1.toString());
        System.out.println();
        System.out.println(cliente2.toString());
        System.out.println();
        System.out.println(cliente3.toString());
        System.out.println();

        System.out.println(mesaskol.toString());
        System.out.println(mesaschin.toString());

        System.out.println("Indice da coca: " + cardapio.buscarItem("069"));



    }
}
