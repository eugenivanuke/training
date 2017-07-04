package dbService.dao;

import dbService.dataSets.UsersDataSets;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by clr on 14.11.2016.
 */
public class UsersDAO {
    private Session session;

    public UsersDAO (Session session) {
        this.session = session;
    }

    public UsersDataSets get(long id) throws HibernateException {
        return (UsersDataSets) session.get(UsersDataSets.class, id);
    }

    public long getUsersId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSets.class);
        return ((UsersDataSets) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }

    public long insertUser(String name, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSets(name, password));
    }
}
