
package ma.projet.domaine;

import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.ChartModel;
import ma.projet.beans.SmartPhone;
import ma.projet.beans.User;
import ma.projet.service.SmartPhoneService;
import ma.projet.service.UserService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
/**
 *
 * @author hp
 */
@ManagedBean(name = "smartphoneBean")
public class SmartPhoneBean {
    
    private User user;
    private SmartPhone smartphone;
    private SmartPhoneService smartphoneService;
    private List<SmartPhone> smartphones;
    private List<User> users;
    private UserService userService;
    private static ChartModel barModel;

    public SmartPhoneBean() {
        smartphone = new SmartPhone();
        smartphoneService = new SmartPhoneService();
        user = new User();
        userService = new UserService();
    }

    public List<User> getUsers() {
        if (users == null) {
            users = smartphone.getUsers();
        }
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<SmartPhone> getSmartPhones() {
        if (smartphones == null) {
            smartphones = smartphoneService.getAll();
        }
        return smartphones;
    }
    
    public void setSmartPhones(List<SmartPhone> smartphones) {
        this.smartphones = smartphones;
    }

    public SmartPhone getSmartPhone() {
        return smartphone;
    }

    public void setSmartPhone(SmartPhone smartphone) {
        this.smartphone = smartphone;
    }
    
    public String onCreateAction() {
        smartphoneService.create(smartphone);
        smartphone  = new SmartPhone();
        return null;
    }

    public void onDeleteAction() {
        smartphone.setUsers(null);
        smartphoneService.delete(smartphone);

    }

    public void onEdit(RowEditEvent event) {
        smartphone = (SmartPhone) event.getObject();
        smartphone.setUsers(null);
        smartphoneService.update(smartphone);
    }

    public void load() {
        System.out.println(smartphone.getImei());
        smartphone = smartphoneService.getById(smartphone.getId());
        getUsers();
    }

    public void onCancel(RowEditEvent event) {
    }
    
    public void onEditm(RowEditEvent event) {
        user = (User) event.getObject();
        SmartPhone smartphone = smartphoneService.getById(this.user.getSmartphone().getId());
        user.setSmartphone(smartphone);
        user.getSmartphone().setImei(smartphone.getImei());
        userService.update(user);
    }

    public String onDeleteActionm() {

        userService.delete(userService.getById(user.getId()));
        return null;
    }

    public List<User> smartphoneLoad() {
        for (User m : userService.getAll()) {
            if (m.getSmartphone().equals(smartphone)) {
                users.add(m);
            }
        }
        return users;

    }

    public void onCancelm(RowEditEvent event) {
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries smartphones = new ChartSeries();
        smartphones.setLabel("SmartPhones");
        model.setAnimate(true);
        for (SmartPhone s : smartphoneService.getAll()) {
            smartphones.set(s.getImei(), s.getUsers().size());
        }
        model.addSeries(smartphones);
        
                
        return model;
    }
}
