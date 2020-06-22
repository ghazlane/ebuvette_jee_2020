package com.e_buvette.ebuvette.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.e_buvette.ebuvette.models.User;
import com.e_buvette.ebuvette.repository.UserRepository;

@FacesValidator("com.ebuvette.EmailValidator")
public class EmailValidator implements Validator{

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;
	
	private UserRepository userRepo ;
	 @ManagedProperty("#{authController.user}")
	private User user; 

	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
		 
	}

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){

			FacesMessage msg =
				new FacesMessage("E-mail erreur",
						"* Email invalide.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
		if(user != null){

			FacesMessage msg =
				new FacesMessage("user erreur",
						"Email existant.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}
}
