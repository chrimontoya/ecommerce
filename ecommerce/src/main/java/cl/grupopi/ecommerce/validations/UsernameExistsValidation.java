package cl.grupopi.ecommerce.validations;
import cl.grupopi.ecommerce.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UsernameExistsValidation implements ConstraintValidator<UsernameAlreadyExists, String> {
    @Autowired
    private UserService userService;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(userService == null){
            return true;
        }
        return !userService.existsByUsername(username);
    }
}
