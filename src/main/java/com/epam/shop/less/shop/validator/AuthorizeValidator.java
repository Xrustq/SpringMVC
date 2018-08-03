package com.epam.shop.less.shop.validator;

import com.epam.shop.less.shop.entity.LoginUser;
import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AuthorizeValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return LoginUser.class.equals(aClass);
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    public void validate(Object o, Errors errors) {
        LoginUser user = (LoginUser) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (!isValidEmailAddress(user.getEmail())) {
            errors.rejectValue("email", "InvalidEmail.userForm.email");
        }

        if (userService.getUserByEmail(user.getEmail()) == null) {
            errors.rejectValue("email", "NotFoundUser.userForm.email");
        }

        if (!userService.getUserByEmail(user.getEmail()).getPassword().equals(user.getPassword())) {
            errors.rejectValue("password", "InvalidPass.userForm.password");
        }
    }

}
