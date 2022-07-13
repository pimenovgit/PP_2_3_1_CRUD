package app.dao;

import app.model.Users;

import java.util.List;

public interface UserDao {
    public void createUser(Users user);
    public void updateUser(Users user);
    public void removeUser(long id);
    public Users getUserId(long id);
    public List<Users> getAllUsers();
}
