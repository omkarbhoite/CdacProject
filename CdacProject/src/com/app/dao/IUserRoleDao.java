package com.app.dao;

import java.util.List;

import com.app.pojos.UserRole;

public interface IUserRoleDao {
	List<UserRole> getUserList();
	UserRole getUserById(int Id);

	UserRole addUserDetailsInfo(String email,String Password);

	void deleteUserDetails(UserRole u);

	
	void updateUserRole(UserRole u, UserRole s);

}
