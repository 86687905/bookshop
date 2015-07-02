package bookshop.dao;

import bookshop.domain.Logs;

public interface LogsDao {

	public abstract void save(Logs logs);

	public abstract void delete(Logs logs);

	public abstract void deleteById(Integer id);
	
	public abstract Logs findById(Integer id);

	public abstract void update(Logs logs);

}