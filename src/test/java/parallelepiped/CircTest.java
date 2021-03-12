package parallelepiped;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CircTest {

    @Test
    public void getDes() {
        BigDecimal x = new BigDecimal(1);
        Circ circ = new Circ("2", x, x, x);
        assert(circ.getDes() != null);
    }
}