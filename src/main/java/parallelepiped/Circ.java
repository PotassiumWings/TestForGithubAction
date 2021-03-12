package parallelepiped;

import java.math.BigDecimal;

public class Circ {
    private String type;
    private BigDecimal r1;
    private BigDecimal r2;
    private BigDecimal ht;
    private BigDecimal pi = new BigDecimal(Math.PI);

    public Circ(String type, BigDecimal r1, BigDecimal r2, BigDecimal ht) {
        this.type = type;
        this.r1 = r1;
        this.r2 = r2;
        this.ht = ht;
    }

    public BigDecimal getVolume() {
        switch (type) {
            case "2":
                if (r1.compareTo(r2) == 0) {
                    return r1.multiply(r1).multiply(pi).multiply(ht);
                }
                BigDecimal x = r1.multiply(ht).divide(r2.subtract(r1),
                        20, BigDecimal.ROUND_HALF_EVEN);
                return x.add(ht).multiply(r2).multiply(r2).multiply(pi).
                        divide(new BigDecimal("3"), 20,
                                BigDecimal.ROUND_HALF_EVEN).subtract(
                        r1.multiply(r1).multiply(pi).multiply(x).
                                divide(new BigDecimal("3"), 20,
                                        BigDecimal.ROUND_HALF_EVEN)
                );
            case "2.1":
                return r1.multiply(r1).multiply(pi).multiply(ht);
            case "2.2":
                return r1.multiply(r1).multiply(pi).
                        multiply(ht).divide(new BigDecimal("3"), 20,
                        BigDecimal.ROUND_HALF_EVEN);
            default:
                return new BigDecimal("4").multiply(pi).multiply(r1).
                        multiply(r1).multiply(r1).divide(new BigDecimal("3"),20,
                        BigDecimal.ROUND_HALF_EVEN);
        }
    }

    public String getDes() {
        switch (type) {
            case "2": return r1 + " " + r2 + " " + ht;
            case "2.1": case "2.2":  return r1 + " " + ht;
            default: return r1 + "";
        }
    }

}
