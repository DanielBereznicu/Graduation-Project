package ro.itschool.service;

import java.util.List;

import ro.itschool.dao.PTrainerDao;
import ro.itschool.entity.PTrainer;

public class PTrainerService {
	private PTrainerDao pTrainerDao;

	public PTrainerService() {
		super();
		this.pTrainerDao = new PTrainerDao();

	}

	public void savePTrainer(PTrainer pTrainer) {
		pTrainerDao.openCurrentSessionwithTransaction();
		pTrainerDao.persist(pTrainer);
		pTrainerDao.closeCurrentSessionwithTransaction();
	}

	public void updatePTrainer(PTrainer pTrainer) {
		pTrainerDao.openCurrentSessionwithTransaction();
		pTrainerDao.update(pTrainer);
		pTrainerDao.closeCurrentSessionwithTransaction();

	}

	public PTrainer findById(int id) {
		pTrainerDao.openCurrentSession();
		PTrainer pTrainer = pTrainerDao.findById(id);
		pTrainerDao.closeCurrentSession();
		return pTrainer;
	}

	public void deletePTrainer(PTrainer pTrainer) {
		pTrainerDao.openCurrentSessionwithTransaction();
		pTrainerDao.delete(pTrainer);
		pTrainerDao.closeCurrentSessionwithTransaction();
	}

	public List<PTrainer> findAllPTrainers() {
		pTrainerDao.openCurrentSession();
		List<PTrainer> pTrainers = pTrainerDao.findAll();
		pTrainerDao.closeCurrentSession();
		return pTrainers;
	}

	public void deleteAllPTrainers() {
		pTrainerDao.openCurrentSessionwithTransaction();
		pTrainerDao.deleteAll();
		pTrainerDao.closeCurrentSessionwithTransaction();
	}
}
