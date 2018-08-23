package PZ7.DAO;

import PZ7.Entity;

import java.util.List;

/**
 * Created by gaara on 4/24/17.
 */
public interface DaoInter <T extends Entity>{
    List<T> getAll();

    T getById(long id);

    void save(T entity);

    void delete(long id);

    void update (T entity);

}