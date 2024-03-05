package core.model.dto.in;

import java.io.Serializable;

public class RequestKDTO implements Serializable {
    private Integer x;
    private Integer y;
    private Integer n;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public RequestKDTO(Integer x, Integer y, Integer n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public RequestKDTO() {

    }

}
