import java.math.BigDecimal;
import java.time.LocalDate;

public class Compra {

    private String descricaoCompra;
    private BigDecimal valor;

    public Compra(String descricaoCompra, BigDecimal valor) {
        this.descricaoCompra = descricaoCompra;
        this.valor = valor;
    }

    public String getDescricaoCompra() {
        return descricaoCompra;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return LocalDate.now() + " "
                + descricaoCompra
                + "--------------"
                + " R$ " + String.format("%.2f", valor);
    }
}
