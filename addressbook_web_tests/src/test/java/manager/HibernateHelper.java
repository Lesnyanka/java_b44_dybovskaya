package manager;

import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import model.ContactData;
import model.GroupData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<GroupData> convertList(List<GroupRecord> records){
        List<GroupData> result = new ArrayList<>();
        for(var record : records){
            result.add(convert(record));
        }
        return result;
    }

    static List<ContactData> convertContactList(List<ContactRecord> records){
        List<ContactData> result = new ArrayList<>();
        for(var user : records){
            result.add(convert(user));
        }
        return result;
    }

    private static GroupData convertList(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }



    private static ContactData convertContactList(ContactRecord record) {
        return new ContactData().withId("" + record.id)
                .withLastname(record.lastname)
                .withFirstname(record.firstname)
                .withAddress(record.address);
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        return new GroupRecord(Integer.parseInt(data.id()), data.name(), data.header(), data.footer());
    }

    private static ContactRecord convert(ContactData data) {
        return new ContactRecord(Integer.parseInt(data.id()), data.lastname(), data.firstname(), data.address(), data.email(), data.mobile());
    }

    private static ContactData convert(ContactRecord record) {
        return new ContactData("" + record.id, record.lastname, record.firstname, record.address, record.email, record.mobile);

    public List<GroupData> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public List<ContactData> getContactList() {
        return convertContactList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }



    public long getGroupCount() {
        return (sessionFactory.fromSession(session -> {
             return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        }));
    }

    public long getContactCount() {
        return (sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        }));
    }

    public void createGroup(GroupData groupData) {
       sessionFactory.inSession(session ->{
           session.getTransaction().begin();
           session.persist(convert(groupData));
           session.getTransaction().commit();
       });
    }

    public void createContact(ContactData contactData) {
        sessionFactory.inSession(session ->{
            session.getTransaction().begin();
            session.persist(convert(contactData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            return convertContactList(session.get(GroupRecord.class, group.id()).contacts);

        });
}



