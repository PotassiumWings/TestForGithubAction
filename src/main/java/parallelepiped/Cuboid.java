package parallelepiped;

import java.math.BigDecimal;

public class Cuboid extends Parallelepiped {
    public Cuboid(BigDecimal a, BigDecimal b, BigDecimal c) {
        super(a, new BigDecimal("0"), b,
                new BigDecimal("0"), new BigDecimal("0"), c);
    }

    @Override
    public String getDes() {
        return super.getAx() + " " + super.getBy() + " " + super.getCz();
    }
}
