package in.co.infocraft.services;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import in.co.infocraft.dao.UserDao;
import in.co.infocraft.models.UserModel;

public abstract class UserService {

	@CreateSqlObject
	abstract UserDao userDao();
	
	public List<UserModel> getUsers() {
		return userDao().getUsers();
	}
	
	public UserModel getUser(int id) {
		return userDao().getUser(id);
	}

}
