package model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="lab3285569")
public class Point implements Serializable {

    @Column(name = "x_value")
    private Double x;
    @Column(name = "y_value")
    private Double y;
    @Column(name = "r_value")
    private Double r;
    @Column(name = "result")
    private String res;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Point(){}

    public Point(Double x, Double y, Double r, String res) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Long getId() {
        return id;
    }
}
