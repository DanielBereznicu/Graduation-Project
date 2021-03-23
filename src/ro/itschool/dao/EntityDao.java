package ro.itschool.dao;

import java.util.List;

public interface EntityDao<T, Id> {

	public void persist(T entity);

	public void update(T entity);

	public T findById(Id id);

	public void delete(T entity);

	public List<T> findAll();

	public void deleteAll();

}
