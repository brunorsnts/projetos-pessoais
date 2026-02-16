import java.math.BigDecimal;

public class Cartao {

    private String titular;
    private Fatura fatura = new Fatura(this);
    private BigDecimal limiteDoCartao;

    public Cartao(String titular, BigDecimal limiteDoCartao) {
        this.limiteDoCartao = limiteDoCartao;
        this.titular = titular;
    }

    public BigDecimal getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public String getTitular() {
        return titular;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void realizarCompra(Compra compra) {
        if(!temLimiteDisponivel(compra.getValor())) {
            throw new IllegalArgumentException("Limite indisponível para compras. \nLimite disponível é: R$ " + String.format("%.2f", getLimiteDoCartao()));
        }
        fatura.faturar(compra);
        limiteDoCartao = limiteDoCartao.subtract(compra.getValor());
    }

    private boolean temLimiteDisponivel(BigDecimal valor) {
        return limiteDoCartao.compareTo(valor) >= 0;
    }

    @Override
    public String toString() {
        return "Titular do Cartão: " + getTitular()
                + "Limite do Cartão: R$" + String.format("%.2f", getLimiteDoCartao());
    }
}
