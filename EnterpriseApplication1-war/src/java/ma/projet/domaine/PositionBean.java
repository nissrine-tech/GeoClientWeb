
package ma.projet.domaine;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import ma.projet.beans.Position;
import ma.projet.beans.SmartPhone;
import ma.projet.beans.User;
import ma.projet.service.PositionService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author hp
 */
@ManagedBean(name = "positionBean")
@RequestScoped
public class PositionBean {
    private Position position;
    private List<Position> positions;
    private PositionService ps;

    private static final MapModel simpleModel = new DefaultMapModel();
    private Marker marker;

    public PositionBean() {
        position = new Position();
        ps = new PositionService();
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Position getPosition() {
        return position;
    }

    public void setHotel(Position position) {
        this.position = position;
    }

    public List<Position> getPositions() {
        if (positions == null) {
            positions = ps.getAll();
        }
        return positions;
    }

    public void setHotels(List<Position> positions) {
        this.positions = positions;
    }

    @PostConstruct
    public void init() {
        for (Position h : ps.getAll()) {
            LatLng coord1 = new LatLng(h.getLatitude(), h.getLongitude());
            simpleModel.addOverlay(new Marker(coord1, h.getNom()));
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Position : ", marker.getTitle()));
    }

    public void onDeleteAction() {
        ps.delete(position);

    }

    public void onEdit(RowEditEvent event) {
        position = (Position) event.getObject();
        //position.setUsers(null);
        ps.update(position);
    }

    public void load() {
        System.out.println(position.getNom());
        position = ps.getById(position.getId());
        //getUsers();
    }
    public String onCreate() {
        ps.create(position);
        this.position = null;
        return null;
    }
    public void onCancel(RowEditEvent event) {
    }

    public void onCancelm(RowEditEvent event) {
    }

}
