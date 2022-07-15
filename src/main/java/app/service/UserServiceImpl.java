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

    @Transactional
    @Override
    public void updateUser(Users user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Transactional
    @Override
    public Users getUserId(Long id) {
        return userDao.getUserId(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }
}
