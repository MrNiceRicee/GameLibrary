package data;

import java.util.List;

public interface UserDataAccessInterface <T> {

	public List<T> findAll();
	public T findById(int Id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);

}
