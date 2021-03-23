package ro.itschool.curs;

import GUI.LaunchPage;
import GUI.ManageMembers;
import ro.itschool.entity.Member;
import ro.itschool.entity.PTrainer;
import ro.itschool.enums.Specializations;
import ro.itschool.service.MemberService;
import ro.itschool.service.PTrainerService;

public class App {

	public static void main(String[] args) {
//		PTrainerService pTrainerService = new PTrainerService();
		MemberService memberService = new MemberService();
//        PTrainer pTrainer = new PTrainer("pTrainer3", "pTrain3", Specializations.BODYBUILDING);
//		Member member = new Member("member2", "member2", Date.valueOf("2010-10-10"), pTrainer );
//		memberService.saveMember(member);
//		pTrainerService.savePTrainer(pTrainer);
//		PTrainerService trainers = new PTrainerService();
//		System.out.println(trainers.findById(2));
		
//	    memberService.deleteAllMembers();
//		member.setName("Dani");
//		memberService.updateMember(member);
//		
//		System.out.println(memberService.findAllMembers());
//		System.out.println(pTrainerService.findAllPTrainers());
        LaunchPage launchPage = new LaunchPage();
		
		}
	}


