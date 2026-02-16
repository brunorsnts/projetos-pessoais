# Sistema de Cartão de Crédito e Gerenciador de Compras

Este projeto é uma aplicação Java backend que simula o funcionamento central de um cartão de crédito. O sistema gerencia limites, valida transações em tempo real e consolida gastos em uma fatura detalhada.

O projeto foi desenvolvido com foco em **Programação Orientada a Objetos (POO)** e **precisão financeira** (evitando erros de arredondamento comuns em computação).

## 🎯 Funcionalidades

- **Criação de Cartão:** Configuração inicial com titular e limite de crédito.
- **Processamento de Compras:**
    - Validação automática de saldo disponível.
    - Bloqueio de compras que excedam o limite (Lançamento de exceções).
    - Atualização dinâmica do saldo do cartão.
- **Geração de Fatura:**
    - Histórico detalhado de todas as compras aprovadas.
    - Cálculo automático do valor total a pagar.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Java 17**
* **BigDecimal:** Utilizado em todas as operações monetárias. Diferente do `double`, o `BigDecimal` garante precisão decimal exata, fundamental para sistemas financeiros.
* **Encapsulamento e Delegação:**
    * `Cartao`: Responsável exclusivamente por gerir o limite e validar a compra.
    * `Fatura`: Responsável por armazenar o histórico e calcular totais.
* **Java Collections Framework:** Uso de `List` e `ArrayList` para manipulação dinâmica dos dados.
* **Imutabilidade:** Objetos de valor (como a classe `Compra`) são imutáveis após sua criação.

## 💻 Estrutura do Projeto

O código está organizado nas seguintes classes principais:

| Classe | Responsabilidade |
| :--- | :--- |
| **Main** | Ponto de entrada. Gerencia a interação com o usuário (I/O), converte inputs para `BigDecimal` e orquestra o fluxo. |
| **Cartao** | O "Core" do sistema. Guarda o limite atual e decide se uma compra pode ou não ser aprovada. |
| **Compra** | Representa o objeto da transação (descrição + valor). Utiliza `LocalDate` para registro. |
| **Fatura** | Acumula as compras aprovadas e mantém o somatório total da dívida. |

## 🚀 Como Executar

1.  Certifique-se de ter o **Java 17** (ou superior) instalado.
2.  Clone este repositório.
3.  Abra o projeto na sua IDE preferida (IntelliJ, Eclipse, VS Code).
4.  Execute a classe `Main.java`.

### Exemplo de Uso (Terminal)

```text
Digite o valor do seu limite de crédito: 1000.00
Digite o nome do Titular do Cartão: Bruno

Digite o valor da compra: 250.50
Digite a descrição da compra: Tênis Nike
Caso queira sair digite "sair"! [ENTER]

... (Após várias compras) ...

Fatura gerada em: 2026-02-16T14:30:00Z
2026-02-16 Tênis Nike -------------- R$ 250.50
2026-02-16 Mercado -------------- R$ 400.00
Valor total: 650.50
```

---

Desenvolvido por [Bruno Santos](https://github.com/brunorsnts)