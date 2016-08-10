package com.devcolibri.bean;

import com.devcolibri.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local
public class UserBean {

    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;


    public User add(User user){
        return em.merge(user);
    }


    public User get(long id){
        return em.find(User.class, id);
    }

    public void update(User user){
        add(user);
    }


    public void delete(long id){
        em.remove(get(id));
    }


    public List<User> getAll(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }

}
