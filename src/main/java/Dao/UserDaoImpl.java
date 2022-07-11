package Dao;

import model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void removeUser(long id) {
        TypedQuery<Users> query = entityManager.createQuery("Delete From Users where  id = :id", Users.class)
                .setParameter("id", id);
    }

    @Override
    public Users getUserId(long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("select u from Users u", Users.class).getResultList();

    }
}
