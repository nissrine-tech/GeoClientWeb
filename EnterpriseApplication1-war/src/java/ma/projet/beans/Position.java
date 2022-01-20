package ma.projet.beans;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Position {
         @Id
         @GeneratedValue
	private int id;
         private String nom;
	private Double latitude;
	private Double longitude;
         
	public Position() {
		super();
	}   

        public Position(int id, String nom, Double latitude, Double longitude) {
            this.id = id;
            this.nom = nom;
            this.latitude = latitude;
            this.longitude = longitude;
        }

    public Position(String nom, Double latitude, Double longitude) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
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
        
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}   
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}   

}
