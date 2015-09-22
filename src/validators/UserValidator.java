package validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import models.User;

/**
 * User form validator
 * @author Administrator
 *
 */
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "username", "post.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "post.required");
	}

}
