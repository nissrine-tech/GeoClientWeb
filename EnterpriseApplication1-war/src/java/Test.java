
import ma.projet.beans.SmartPhone;
import ma.projet.beans.Position;
import ma.projet.service.PositionService;
import ma.projet.service.UserService;
import ma.projet.service.SmartPhoneService;


public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SmartPhoneService ss = new SmartPhoneService();
        //création des Salles
        ss.create(new SmartPhone("Iphone22"));
        ss.create(new SmartPhone("Oppo33"));
        ss.create(new SmartPhone("samsung44"));
        //La liste des salles
        for (SmartPhone s : ss.getAll()) {
            System.out.println("" + s.getImei());
        }    /*
        PositionService sn = new PositionService();
        //création des Salles
        sn.create(new Position("Marrakech",31.630000, -8.008889));
        sn.create(new Position("Agadir",30.427755, -9.598107));
        sn.create(new Position("Tanger",35.759465, -5.833954));
        //La liste des salles
        for (Position s : sn.getAll()) {
            System.out.println("" + s.getNom());
        }*/
    }
}
