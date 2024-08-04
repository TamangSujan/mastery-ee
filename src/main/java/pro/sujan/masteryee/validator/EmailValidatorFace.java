package pro.sujan.masteryee.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;

import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Pattern;

@FacesValidator
public class EmailValidatorFace implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String email = (String) object;
        if(!isValidEmail(email)) {
            HtmlInputText inputText = (HtmlInputText) uiComponent;
            FacesMessage facesMessage = new FacesMessage(inputText.getLabel()+": Invalid Email!");
            throw new ValidatorException(facesMessage);
        }
    }

    private boolean isValidEmail(String email){
        return Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
                .matcher(email).matches();
    }
}
