package validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import models.Post;

/**
 * Post form validator
 * @author Administrator
 *
 */
public class PostValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Post.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "title", "post.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "content", "post.required");
	}

}
