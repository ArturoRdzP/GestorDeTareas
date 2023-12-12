package AccionesprimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.badge.BadgeModel;
import org.primefaces.model.badge.DefaultBadgeModel;

@Named
@RequestScoped
public class MenuBadgeView {

    private BadgeModel badgeModel;

    @PostConstruct
    public void init() {
        badgeModel = DefaultBadgeModel.builder()
                .severity("danger")
                .build();
    }

    public BadgeModel getBadgeModel() {
        return badgeModel;
    }
}