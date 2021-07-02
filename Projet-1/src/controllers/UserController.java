package controllers;

import java.util.List;

import dao.UserDao;
import models.User;
import views.ResUfrView;
import views.UserView;

public class UserController {

	private UserDao userDao = new UserDao();;

	public UserController() {

	}

	public void openLoginView() {
		UserView loginView = new UserView();
		loginView.setVisible(true);
	}

	public User login(String username, String password) {
		return userDao.login(username, password);
	}
	
	public Boolean isUsernameExists(String username) {
		return userDao.isUsernameExists(username);
	}

	public Object[][] getAllUsers() {
		List<User> listUsers = (List<User>) userDao.getAllUsers();
		Object[][] listUsersObject = new Object[listUsers.size()][6];
		for (int i = 0; i < listUsers.size(); i++) {
			listUsersObject[i][0] = listUsers.get(i).getId();
			listUsersObject[i][1] = listUsers.get(i).getName();
			listUsersObject[i][2] = listUsers.get(i).getUsername();
			listUsersObject[i][3] = listUsers.get(i).getPassword();
			listUsersObject[i][4] = listUsers.get(i).getRole();
			listUsersObject[i][5] = "Delete";
		}
		return listUsersObject;
	}

	public void openByRole(User user) {
		switch (user.getRole()) {
		case "responsable UFR": {
			System.out.println("Opening Responsable Formation window...");
			ResUfrView resForView = new ResUfrView(user);
			resForView.setVisible(true);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + user);
		}

	}

	public Boolean saveNewUser(String name, String password, String username, String role) {
		User newUser = new User(username,name,role,password);
		return userDao.saveUser(newUser);
	}

	public Boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	public Boolean updateUser(int id, String name, String username, String password, String role) {
		User newUser = new User(id,username,name,role,password);
		return userDao.updateUser(newUser);
		
	}


}
