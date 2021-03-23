package ro.itschool.service;

import java.util.List;

import ro.itschool.dao.MemberDao;
import ro.itschool.entity.Member;

public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		super();
		this.memberDao = new MemberDao();
	}

	public void saveMember(Member member) {
		memberDao.openCurrentSessionwithTransaction();
		memberDao.persist(member);
		memberDao.closeCurrentSessionwithTransaction();
	}

	public void updateMember(Member member) {
		memberDao.openCurrentSessionwithTransaction();
		memberDao.update(member);
		memberDao.closeCurrentSessionwithTransaction();

	}

	public Member findById(int id) {
		memberDao.openCurrentSession();
		Member member = memberDao.findById(id);
		memberDao.closeCurrentSession();
		return member;
	}

	public void deleteMember(Member member) {
		memberDao.openCurrentSessionwithTransaction();
		memberDao.delete(member);
		memberDao.closeCurrentSessionwithTransaction();
	}

	public List<Member> findAllMembers() {
		memberDao.openCurrentSession();
		List<Member> members = memberDao.findAll();
		memberDao.closeCurrentSession();
		return members;
	}

	public void deleteAllMembers() {
		memberDao.openCurrentSessionwithTransaction();
		memberDao.deleteAll();
		memberDao.closeCurrentSessionwithTransaction();
	}
	public void deleteById(int id) {
		memberDao.openCurrentSessionwithTransaction();
		memberDao.deleteId(id);
		memberDao.closeCurrentSessionwithTransaction();
	}

}
