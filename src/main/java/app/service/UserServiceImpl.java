package app.service;


import app.dao.UserDao;
import app.dao.UserDaoImpl;
import app.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void createUser(Users user) {

    }

    @Override
    public void updateUser(Users user) {
        userDao.updateUser(user);
    }

    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    public Users getUserId(long id) {
        return userDao.getUserId(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }
}
