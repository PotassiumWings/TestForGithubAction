package vector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {
    private Vector vec1 = null;
    private Vector vec2 = null;

    @Before
    public void setUp() throws Exception {
        vec1 = new Vector(2, -3, 4);
        vec2 = new Vector(3, -4, 5);
    }

    @After
    public void tearDown() throws Exception {
        vec1 = null;
        vec2 = null;
    }

    @Test
    public void add() {
        Vector vec3 = vec1.add(vec2);
        Assert.assertEquals(vec3.getX(), vec1.getX() + vec2.getX(), 1e-7);
        Assert.assertEquals(vec3.getY(), vec1.getY() + vec2.getY(), 1e-7);
        Assert.assertEquals(vec3.getZ(), vec1.getZ() + vec2.getZ(), 1e-7);
    }

    @Test
    public void sub() {
        Vector vec3 = vec1.sub(vec2);
        Assert.assertEquals(vec3.getX(), vec1.getX() - vec2.getX(), 1e-7);
        Assert.assertEquals(vec3.getY(), vec1.getY() - vec2.getY(), 1e-7);
        Assert.assertEquals(vec3.getZ(), vec1.getZ() - vec2.getZ(), 1e-7);
    }

    @Test
    public void dot() {
        double res = vec1.dot(vec2);
        assert(res == vec1.getX() * vec2.getX() + vec1.getY() * vec2.getY() + vec1.getZ() * vec2.getZ());
    }
}