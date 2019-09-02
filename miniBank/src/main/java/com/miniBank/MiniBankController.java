package com.miniBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.miniBank.model.User;
import com.miniBank.model.UserOperationTable;
import com.miniBank.repos.UserOperationTableRepos;
import com.miniBank.repos.UserRepos;
import com.miniBank.service.CurrentUser;

@Controller
public class MiniBankController {
	@Autowired
	private UserRepos userRepository;

	@Autowired
	private UserOperationTableRepos userOperationRepository;
	
//----------------Open by request
	@RequestMapping("/main")
	public String showIndex() {
		return "main";
	}

	@RequestMapping("/createaccaunt")
	public String showCreateaccaunt() {
		return "createaccount";
	}

	@RequestMapping("/usersection")
	public String showUsersection() {
		return "usersection";
	}

//----------------Open by POST request

	@PostMapping("main")
	public String mainPOST(@RequestParam String email, @RequestParam String pssw) {
		System.out.println("<Login> email: " + email + " password: " + pssw);
		List<User> user = userRepository.findByEmailAndPassword(email, pssw);
		if (user.size() == 1) {
			CurrentUser.userID = (user.get(0).getId()); 
			System.out.println("User ID: " + CurrentUser.userID);
			return "usersection";
		} else {
			System.out.println("USER NOT FOUND");
			return "main";
		}
	}

	@PostMapping("createaccaunt")
	public String createaccountPOST(@RequestParam String emailC, @RequestParam String psswC) {
		System.out.println("<Create user account> email: " + emailC + " password: " + psswC);
		User u = new User();
		u.setPassword(psswC);
		u.setEmail(emailC);
		userRepository.save(u);
		
		List<User> user = userRepository.findByEmailAndPassword(emailC, psswC);
		Integer	userId = user.get(0).getId();
		UserOperationTable ut = new UserOperationTable();
		ut.setUserId(userId);
		ut.setDeposit(0);
		ut.setWithdrawal(0);
		ut.setBalance(0);
		userOperationRepository.save(ut);
		return "main";
	}

	@PostMapping("usersection")
	public String usersectionPOST(@RequestParam String depo, @RequestParam String with) {
		
		System.out.println("<Usersection> Deposit: " + depo + " Withdrawal: " + with);
		long d = 0;
		long w = 0;
		
		if (depo.length() > 0)  d = Long.parseLong(depo);
		if (with.length() > 0)  w = Long.parseLong(with);
		
		
		 List<UserOperationTable> t = userOperationRepository.findAllByUserId(CurrentUser.userID);
	    long b = t.get(t.size()-1).getBalance();
	    b = b - w + d;
	    
		UserOperationTable ut = new UserOperationTable();
		ut.setUserId(CurrentUser.userID);
		ut.setDeposit(d);
		ut.setWithdrawal(w);
		ut.setBalance(b);
		userOperationRepository.save(ut);	    
		return "usersection";
	}
//--------------------test 
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {

		return userRepository.findAll();
	}
	
	@GetMapping(path = "/alloperations")
	public @ResponseBody Iterable<UserOperationTable> getAllUsersOperations() {

		return userOperationRepository.findAll();
	}
}
