package ma.projet.beans;

import java.lang.String;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


@Entity
public class User {
        @Id
        @GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private String telephone;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateCreation;
        @ManyToOne
         private SmartPhone smartphone;

	public User() {
            smartphone = new SmartPhone();
	}   

    public User(String nom, String prenom, String telephone, SmartPhone smartphone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.smartphone = smartphone;
    }

    public User(String nom, String prenom, String telephone, Date dateCreation, SmartPhone smartphone) {
            this.nom = nom;
            this.prenom = prenom;
            this.telephone = telephone;
            this.dateCreation = dateCreation;
            this.smartphone = smartphone;
        }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

        public SmartPhone getSmartphone() {
            return smartphone;
        }

        public void setSmartphone(SmartPhone smartphone) {
            this.smartphone = smartphone;
    }
	
       
	
}
