package pro.sujan.masteryee.ajax;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class TextController implements Serializable {
    private String text;
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
}
