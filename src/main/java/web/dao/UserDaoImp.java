package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {
        TypedQuery<User> typedQuery = em.createQuery("from User", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void update(User updatedUser) {
        em.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        em.remove(get(id));
    }

    @Override
    public User loadUserByUsername(String username) {
        return em.find(User.class, username);
        //return em.createQuery("SELECT User FROM User user WHERE user.username = :username", User.class).setParameter("username", username).getSingleResult();
    }
}