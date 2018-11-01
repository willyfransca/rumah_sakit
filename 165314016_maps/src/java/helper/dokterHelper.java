/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Dokter;
import util.NewHibernateUtil;

/**
 *
 * @author basisa22
 */
public class dokterHelper {
    public List<Dokter> bacaSemuaDokter() {
        List<Dokter> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Dokter l");
        list = q.list();
        tx.commit();
        session.close();
        return list;
    }
   
}
