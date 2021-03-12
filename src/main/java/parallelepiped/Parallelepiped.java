package parallelepiped;

import java.math.BigDecimal;

public class Parallelepiped {
    private BigDecimal ax;
    private BigDecimal bx;
    private BigDecimal by;
    private BigDecimal cx;
    private BigDecimal cy;
    private BigDecimal cz;

    public Parallelepiped(BigDecimal ax, BigDecimal bx, BigDecimal by,
                          BigDecimal cx, BigDecimal cy, BigDecimal cz) {
        this.ax = ax;
        this.bx = bx;
        this.by = by;
        this.cx = cx;
        this.cy = cy;
        this.cz = cz;
    }

    public BigDecimal getAx() {
        return ax;
    }

    public void setAx(BigDecimal ax) {
        this.ax = ax;
    }

    public BigDecimal getBx() {
        return bx;
    }

    public void setBx(BigDecimal bx) {
        this.bx = bx;
    }

    public BigDecimal getBy() {
        return by;
    }

    public void setBy(BigDecimal by) {
        this.by = by;
    }

    public BigDecimal getCx() {
        return cx;
    }

    public void setCx(BigDecimal cx) {
        this.cx = cx;
    }

    public BigDecimal getCy() {
        return cy;
    }

    public void setCy(BigDecimal cy) {
        this.cy = cy;
    }

    public BigDecimal getCz() {
        return cz;
    }

    public void setCz(BigDecimal cz) {
        this.cz = cz;
    }

    public BigDecimal getVolume() {
        return ax.multiply(by).multiply(cz).abs();
    }

    public String getDes() {
        return ax + " " + bx + " " + by + " " + cx + " " + cy + " " + cz;
    }

}
