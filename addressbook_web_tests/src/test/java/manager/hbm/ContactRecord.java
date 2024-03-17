package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")

public class ContactRecord {
@Id
    public int id;

    public String lastname;

    public String firstname;

    public String address;

    public Date deprecated = new Date();

    public ContactRecord(){}

    public ContactRecord(int id, String lastname, String firstname, String address){

        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }
}
