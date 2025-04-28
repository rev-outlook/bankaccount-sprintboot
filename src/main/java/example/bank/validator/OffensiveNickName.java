package example.bank.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OffensiveNickNameValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OffensiveNickName {
    String message() default "Nickname is offensive";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
