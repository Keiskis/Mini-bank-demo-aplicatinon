package com.miniBank.service;

import java.util.List;
import com.miniBank.model.UserOperationTable;
import com.miniBank.repos.UserOperationTableRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniBankService {
	@Autowired
	private UserOperationTableRepos userOperationRepository;
	
	public List<UserOperationTable>  findAll(int id)
	{
		return userOperationRepository.findAllByUserId(id);
	}
}