package view;

import model.dao.EntityDao;
import model.dao.PointDao;
import model.entities.Point;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

public class SubmitView {

    public SubmitView(){
        this.selectedX = new Double[]{0d};
        this.selectedY = 0d;
        this.selectedR = 1d;
    }

    EntityDao<Point> entityDao = new PointDao();


    Double[] selectedX;
    Double selectedY;
    Double selectedR;

    Double clickedX;
    Double clickedY;

    public static ArrayList<Double> xValues = new ArrayList<>();
    public static ArrayList<Double> rValues = new ArrayList<>();
    static{
        xValues.add(-5d);
        xValues.add(-4d);
        xValues.add(-3d);
        xValues.add(-2d);
        xValues.add(-1d);
        xValues.add(0d);
        xValues.add(1d);

        rValues.add(1d);
        rValues.add(2d);
        rValues.add(3d);
        rValues.add(4d);
        rValues.add(5d);
    }


    public Double[] getSelectedX() {
        return selectedX;
    }

    public ArrayList<Double> getXValues() {
        return xValues;
    }

    public Double getSelectedY() {
        return selectedY;
    }

    public Double getSelectedR() {
        return selectedR;
    }

    public ArrayList<Double> getRValues() {
        return rValues;
    }

    private boolean checkValues(Double[] selectedX, Double selectedY, Double selectedR){
        if ((selectedX!=null)&&(selectedY!=null)&&(selectedR!=null)){
        for (Double x:selectedX) if (!((x>=-5)&&(x<=1))) return false;
        return (selectedY >= -5) && (selectedY <= 5) && (selectedR<=5) && (selectedR>=1);
        }
        else return false;
    }

    private String checkHit(Double x, Double y, Double r){
        if (((x >= -r) && (x <= 0) && (y <= 0) && (y >= -r / 2)) || (x >= -r / 2) && (x <= 0) && (y <= r / 2 + x) && (y >= 0) || (x >= 0) && (y >= 0) && (x * x + y * y <= r * r / 4)) return "YES";
        else return "NO";
    }

    public void setSelectedX(Double[] selectedX) {
        this.selectedX = selectedX;
    }

    public void setSelectedY(Double selectedY) {
        this.selectedY = selectedY;
    }

    public void setSelectedR(Double selectedR) {
        this.selectedR = selectedR;
    }


    public void submit(){
        if (!checkValues(selectedX, selectedY, selectedR)) return;
        for (Double x:selectedX){
            String currentResult = checkHit(x, selectedY, selectedR);
            Point point = new Point(x,selectedY,selectedR,currentResult);
            entityDao.insertEntity(point);
        }

    }

    public void submitByClick(){
        if (!checkValues(new Double[]{clickedX},clickedY,selectedR)) return;
        String currentResult = checkHit(clickedX,clickedY,selectedR);
        Point point = new Point(clickedX,clickedY,selectedR,currentResult);
        entityDao.insertEntity(point);
    }


    public Double getClickedX() {
        return clickedX;
    }

    public void setClickedX(Double clickedX) {
        this.clickedX = clickedX;
    }

    public Double getClickedY() {
        return clickedY;
    }

    public void setClickedY(Double clickedY) {
        this.clickedY = clickedY;
    }
}
