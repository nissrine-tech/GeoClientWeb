
import java.util.Date;
import ma.projet.beans.User;
import ma.projet.beans.SmartPhone;
import ma.projet.service.UserService;
import ma.projet.service.SmartPhoneService;


public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserService ms = new UserService();
        SmartPhoneService ss = new SmartPhoneService();
        //Création des machines
        ms.create(new User("nissrine", "cherkaoui", "03752", new Date(), ss.getById(1)));
        ms.create(new User("nada", "cherkaoui", "03752", new Date(), ss.getById(1)));
        ms.create(new User("naima", "cherkaoui", "03752", new Date(), ss.getById(1)));
        //Afficher les machines par salle
        for(SmartPhone s : ss.getAll()){
            System.out.println("smartphone  : "+s.getImei()+" : ");
            for(User m : s.getUsers())
                System.out.println("\t"+m.getNom());
        }
    }
}
