package in.co.infocraft.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import in.co.infocraft.models.UserModel;

public class UserMapper implements ResultSetMapper<UserModel> {
	
	private static final String ID = "id";
	private static final String USERNAME = "username";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String ISADMIN = "is_admin";
	private static final String ISACTIVE = "is_active";

	public UserModel map(int arg0, ResultSet result, StatementContext arg2) throws SQLException {
		// TODO Auto-generated method stub
		return new UserModel(result.getInt(ID), result.getString(USERNAME), result.getString(EMAIL),
				result.getString(PASSWORD), result.getBoolean(ISADMIN), result.getBoolean(ISACTIVE));
	}

}
