package ma.projet.beans;

import java.lang.String;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SmartPhone{
        @Id
        @GeneratedValue
	private int id;
	private String imei;
	@OneToMany (mappedBy = "smartphone",fetch = FetchType.EAGER)
        private List<User> users;
  
        public SmartPhone() {
	
	}
        public SmartPhone(String imei) {
		this.imei = imei;
	}
  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

   
	
}
