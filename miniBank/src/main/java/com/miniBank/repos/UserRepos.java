package com.miniBank.repos;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.miniBank.model.User;

public interface UserRepos extends CrudRepository<User, Integer> {
	List <User> findByEmailAndPassword(String email, String password);

}