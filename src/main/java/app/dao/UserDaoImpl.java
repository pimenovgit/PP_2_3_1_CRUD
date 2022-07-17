package app.dao;

import app.model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(Users user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(Users user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(getUserId(id));
    }

    @Override
    public Users getUserId(Long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("from Users", Users.class).getResultList();

    }
}
