package parallelepiped;

import java.math.BigDecimal;

public class Cube extends Parallelepiped {
    public Cube(BigDecimal a) {
        super(a, new BigDecimal("0"), a,
                new BigDecimal("0"),new BigDecimal("0"), a);
    }

    @Override
    public String getDes() {
        return super.getAx() + "";
    }
}
