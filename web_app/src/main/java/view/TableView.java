package view;


import model.dao.EntityDao;
import model.dao.PointDao;
import model.entities.Point;

import java.util.List;

public class TableView {


    private EntityDao<Point> entityDao = new PointDao();

    public List<Point> getAll(){
        return entityDao.getAll();
    }

    public void clearAll(){
        entityDao.clearAll();
    }


}
