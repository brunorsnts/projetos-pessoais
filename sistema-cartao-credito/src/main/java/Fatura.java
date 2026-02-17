import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fatura {

    private Cartao cartao;
    private List<Compra> compras = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;

    public Fatura(Cartao cartao) {
        this.cartao = cartao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<Compra> getCompras() {
        compras.sort(Comparator.comparing(Compra::getValor));
        return compras;
    }

    protected void faturar(Compra compra) {
        compras.add(compra);
        total = total.add(compra.getValor());
    }
}
