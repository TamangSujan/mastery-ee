package pro.sujan.masteryee.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator
public class PhoneValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String phone = (String) object;
        if(!isValidPhoneNumber(phone)){
            FacesMessage facesMessage = new FacesMessage(phone+" is an invalid phone number!");
            throw new ValidatorException(facesMessage);
        }
    }

    private boolean isValidPhoneNumber(String phone){
        return phone.startsWith("9") && phone.length() == 10;
    }
}
