import java.math.BigDecimal;
import java.time.Instant;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Define o padrão US para garantir que separadores numéricos sejam compatíveis se usarmos double,
        // embora com BigDecimal e String isso seja menos crítico, é uma boa prática.
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // 1. Configuração Inicial do Cartão
        System.out.print("Digite o valor do seu limite de crédito: ");

        // Lemos o valor como String para evitar a imprecisão natural dos tipos primitivos (double/float).
        // O construtor do BigDecimal recebe a String e mantém a precisão exata dos centavos.
        String limiteDeCredito = sc.nextLine();
        BigDecimal value = new BigDecimal(limiteDeCredito);

        System.out.print("Digite o nome do Titular do Cartão: ");
        String titular = sc.nextLine();

        // Instancia o cartão com os dados iniciais. A Fatura é criada automaticamente dentro do Cartão.
        Cartao cartao = new Cartao(titular, value);

        // 2. Loop de Compras
        String opcao = "";
        while(!opcao.equals("sair")) {
            System.out.print("Digite o valor da compra: ");
            String valor = sc.nextLine();
            value = new BigDecimal(valor); // Novamente, conversão segura de String para BigDecimal

            System.out.print("Digite a descrição da compra: ");
            String descricao = sc.nextLine();

            // Cria o objeto Compra (imutável)
            Compra compra = new Compra(descricao, value);

            try {
                // Tenta realizar a compra. Se não houver limite, o método lançará uma exceção
                // e o fluxo será interrompido (ou poderia ser tratado com um bloco try-catch aqui).
                cartao.realizarCompra(compra);
            } catch (IllegalArgumentException e) {
                // Captura o erro de limite insuficiente lançado pela classe Cartao
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.print("Caso queira sair digite \"sair\"! Se quer realizar uma nova compra tecle enter: ");
            opcao = sc.nextLine();
        }

        // 3. Exibição da Fatura Final
        System.out.println();
        System.out.println("Fatura gerada em: " + Instant.now()); // Data/Hora exata do fechamento

        // Utiliza Stream e Method Reference para imprimir cada compra da lista de forma elegante
        cartao.getFatura().getCompras().forEach(System.out::println);

        // Exibe o total formatado com duas casas decimais
        System.out.println("Valor total: " + String.format("%.2f", cartao.getFatura().getTotal()));

        sc.close();
    }
}