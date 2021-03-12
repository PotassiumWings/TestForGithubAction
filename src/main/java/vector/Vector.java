package vector;

public class Vector {
    private double xx;
    private double yy;
    private double zz;

    public Vector() {
        this.xx = 0;
        this.yy = 0;
        this.zz = 0;
    }

    public double getX() {
        return xx;
    }

    public void setX(double xx) {
        this.xx = xx;
    }

    public double getY() {
        return yy;
    }

    public void setY(double yy) {
        this.yy = yy;
    }

    public double getZ() {
        return zz;
    }

    public void setZ(double zz) {
        this.zz = zz;
    }

    public Vector(double xx, double yy, double zz) {
        this.xx = xx;
        this.yy = yy;
        this.zz = zz;
    }

    public double getMLen() {
        return Math.sqrt(xx * xx + yy * yy + zz * zz);
    }

    public void print() {
        System.out.println(xx + " " + yy + " " + zz);
    }

    public Vector add(Vector b) {
        return new Vector(xx + b.xx, yy + b.yy, zz + b.zz);
    }

    public Vector sub(Vector b) {
        return new Vector(xx - b.xx, yy - b.yy, zz - b.zz);
    }

    public double dot(Vector b) {
        return xx * b.xx + yy * b.yy + zz * b.zz;
    }

    private double cross2(double a, double b, double c, double d) {
        return a * d - b * c;
    }

    public Vector cross(Vector b) {
        return new Vector(cross2(yy, zz, b.yy, b.zz),
                -cross2(xx, zz, b.xx, b.zz), cross2(xx, yy, b.xx, b.yy));
    }
}
