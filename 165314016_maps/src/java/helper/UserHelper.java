/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.User;
import util.NewHibernateUtil;

/**
 *
 * @author basisa12
 */
public class UserHelper {

    public UserHelper() {
    }

    public User cariUser(String email) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from User u where u.email=:email";
        Query q = session.createQuery(query);
        q.setParameter("email", email);
        List<User> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public User login(String email, String password) {
        User user = this.cariUser(email);
        if (user != null) {
            //user ada 
            if (user.getPassword().equals(password)) {
                //password sama
                return user;
            } else {
                //password berbeda
                return null;
            }
        } else {
            //user tidak ada
            return null;
        }
    }

    public List<User> getAllUser() {
        List<User> result = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from User u";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public User getUser(String username, String password) {
        List<User> List = this.getAllUser();
        Collections.sort(List);
        User user = new User(username, password);
        int index = Collections.binarySearch(List, user);
        if (index < 0) {
            return null;
        } else {
            User result = List.get(index);
            if (user.getPassword().equals(result.getPassword())) {
                System.out.println("Password: " + password);
                return user;
            } else {
                return null;
            }
        }
    }
}

