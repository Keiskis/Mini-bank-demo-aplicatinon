package com.miniBank.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniBank.model.UserOperationTable;

@RestController
@RequestMapping("/table")
public class MiniBankRestController {

	@Autowired
	private MiniBankService service;
	@RequestMapping
	public List<UserOperationTable> getTableList() {
		return service.findAll(CurrentUser.userID);
	}
}