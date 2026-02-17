import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cartao {

    private String titular;
    private List<Fatura> faturas = new ArrayList<>();
    private Fatura faturaAberta;
    private BigDecimal limiteDoCartao;

    public Cartao(String titular, BigDecimal limiteDoCartao) {
        this.limiteDoCartao = limiteDoCartao;
        this.titular = titular;
        this.faturaAberta = new Fatura(this);
    }

    public BigDecimal getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public String getTitular() {
        return titular;
    }

    public Fatura getFatura() {
        return faturaAberta;
    }

    public void realizarCompra(Compra compra) {
        if(!temLimiteDisponivel(compra.getValor())) {
            throw new IllegalArgumentException("Limite indisponível para compras. \nLimite disponível é: R$ " + String.format("%.2f", getLimiteDoCartao()));
        }
        faturaAberta.faturar(compra);
        limiteDoCartao = limiteDoCartao.subtract(compra.getValor());
    }

    public void fecharFatura() {
        faturas.add(faturaAberta);
        this.faturaAberta = new Fatura(this);
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
