package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.KeysDao;
import dao.UsersDao;
import model.UserKeys;
import model.Users;

@Service
public class AccountServices {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private KeysDao keyDao;

	@Transactional
	public void registerUser(Users user, UserKeys userKeys) {

		userDao.saveUser(user);
		keyDao.saveKey(userKeys);
	}

}
