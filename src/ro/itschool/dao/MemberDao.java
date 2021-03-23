package ro.itschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.entity.Member;
import ro.itschool.util.HibernateUtils;

@Log
public class MemberDao implements EntityDao<Member, Integer> {
	private Session session;

	private Transaction transaction;

	public MemberDao() {
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
	public void persist(Member entity) {
		log.info("Am apelat metoda persist");
		session.save(entity);

	}

	@Override
	public void update(Member entity) {
		log.info("Am apelat metoda update");
		session.update(entity);

	}

	@Override
	public Member findById(Integer id) {
		log.info("Am apelat metoda find");
		return session.get(Member.class, id);
	}

	@Override
	public void delete(Member entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<Member> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from Member").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from Member").executeUpdate();

	}
	public void deleteId(int id) {
		
		session.createQuery("DELETE FROM Member WHERE Id = " + id).executeUpdate();
		
	}

}
