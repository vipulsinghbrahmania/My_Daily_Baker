package in.co.infocraft.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import in.co.infocraft.mappers.UserMapper;
import in.co.infocraft.models.UserModel;

@RegisterMapper(UserMapper.class)
public interface UserDao {
	
	@SqlQuery("select * from users;")
	public List<UserModel> getUsers();
	
	@SqlQuery("select * from users where id = :id;")
	public UserModel getUser(@Bind("id") final int id);

}
