package model.dao;

import java.util.List;

public interface EntityDao<Entity> {


    void insertEntity(Entity entity);
    void clearAll();
    List<Entity> getAll();
}
