package example.bank.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class OffensiveNickNameValidator implements ConstraintValidator<OffensiveNickName, String> {

    private final List<String> offensiveWords = Arrays.asList("badword", "offensive", "nasty");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // @Size will catch size issues separately

        return offensiveWords.stream().noneMatch(value.toLowerCase()::contains);
    }
}
