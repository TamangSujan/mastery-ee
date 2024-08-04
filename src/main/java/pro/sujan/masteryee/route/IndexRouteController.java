package pro.sujan.masteryee.route;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class IndexRouteController implements Serializable {
    public String toFormDemo(){
        return "/pages/form-demo?faces-redirect=true";
    }
    public String toAjaxDemo(){
        return "/pages/ajax-demo?faces-redirect=true";
    }
    public String toHtml5Demo(){
        return "/pages/html5-demo?faces-redirect=true";
    }
    public String toPassThroughDemo(){
        return "/pages/pass-through-demo?faces-redirect=true";
    }
}
