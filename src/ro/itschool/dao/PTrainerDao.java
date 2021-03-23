package ro.itschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.entity.PTrainer;
import ro.itschool.util.HibernateUtils;

@Log
public class PTrainerDao implements EntityDao<PTrainer, Integer> {
	private Session session;

	private Transaction transaction;

	public PTrainerDao() {
	}

	public Session openCurrentSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() {
		transaction.commit();
		session.close();
	}

	@Override
	public void persist(PTrainer entity) {
		log.info("Am apelat metoda persist");
		session.save(entity);

	}

	@Override
	public void update(PTrainer entity) {
		log.info("Am apelat metoda update");
		session.update(entity);

	}

	@Override
	public PTrainer findById(Integer id) {
		log.info("Am apelat metoda find");
		return session.get(PTrainer.class, id);
	}

	@Override
	public void delete(PTrainer entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<PTrainer> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from PTrainer").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from PTrainer").executeUpdate();

	}

}
