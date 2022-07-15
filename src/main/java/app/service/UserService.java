package app.service;

import app.model.Users;
import java.util.List;

public interface UserService {
    public void createUser(Users user);
    public void updateUser(Users user);
    public void removeUser(Long id);
    public Users getUserId(Long id);
    public List<Users> getAllUsers();
}
