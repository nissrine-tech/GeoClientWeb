/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ma.projet.beans.User;
import ma.projet.beans.SmartPhone;
import ma.projet.service.SmartPhoneService;
import ma.projet.service.UserService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author hp
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {
    private User user;
    private SmartPhone smartphone;
    private List<User> users;
    private List<User> usersBetweenDates;
    private UserService userService;
    private SmartPhoneService smartphoneService;
    private static ChartModel barModel;
    private Date date1;
    private Date date2;
    
    public UserBean() {
        user = new User();
        userService = new UserService();
       // smartphone = new SmartPhone();
        smartphoneService = new SmartPhoneService();
    }
    
    @PostConstruct
    public void init() {
        smartphone = new SmartPhone();
    }

    public List<User> getUsers() {
        if (users == null) {
            users = userService.getAll();
        }
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsersBetweenDates() {
        return usersBetweenDates;
    }

    public void setUsersBetweenDates(List<User> usersBetweenDates) {
        this.usersBetweenDates = usersBetweenDates;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public SmartPhoneService getSmartphoneService() {
        return smartphoneService;
    }

    public void setSmartphoneService(SmartPhoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(ChartModel barModel) {
        UserBean.barModel = barModel;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String onCreateAction() {
        userService.create(user);
        user = new User();
        smartphone = new SmartPhone();
        return null;
    }

    public String onDeleteAction() {

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

    public void load() {
        System.out.println(smartphone.getImei());
        smartphone = smartphoneService.getById(smartphone.getId());
        getUsers();
    }

    public void onEdit(RowEditEvent event) {
        user = (User) event.getObject();
        SmartPhone smartphone = smartphoneService.getById(this.user.getSmartphone().getId());
        user.setSmartphone(smartphone);
        user.getSmartphone().setImei(smartphone.getImei());
        userService.update(user);
    }
    public void onCancel(RowEditEvent event) {
    }
    
    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries users = new ChartSeries();
        users.setLabel("users");
        model.setAnimate(true);
        for (Object[] m : userService.nbuser()) {
            users.set(m[1], Integer.parseInt(m[0].toString()));
        }
        model.addSeries(users);

        return model;
    }
    public List<User> userLoad() {
        usersBetweenDates = userService.getbydates(date1, date2);
        return null;

    }
    
    public SmartPhone getSmartphone() {
        return smartphone;
    }
    public void setSmartphone(SmartPhone smartphone) {
        this.smartphone = smartphone;
    }


}
