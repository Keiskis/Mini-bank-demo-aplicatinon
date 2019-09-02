package com.miniBank.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.miniBank.model.UserOperationTable;

public interface UserOperationTableRepos extends CrudRepository<UserOperationTable, Integer> {
	List <UserOperationTable> findAllByUserId(Integer id);
}
