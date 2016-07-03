package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.KeysDao;
import model.UserKeys;

@Service
public class KeysServices {

	@Autowired
	private KeysDao keysDao;
	
	public UserKeys getKeys(String username){
		
		return keysDao.getKeys(username);
	}
}
