package pro.sujan.masteryee.validator;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

import java.util.regex.Pattern;

@Named
@RequestScoped
public class EmailValidatorCustom {
    public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException{
        String email = (String) object;
        if(!isValidEmail(email)) {
            HtmlInputText inputText = (HtmlInputText) component;
            FacesMessage facesMessage = new FacesMessage(inputText.getLabel()+": Invalid Email!");
            throw new ValidatorException(facesMessage);
        }
    }

    private boolean isValidEmail(String email){
        return Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
                .matcher(email).matches();
    }
}
