package br.com.ruderson.portfolio_restful.DTO.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            Field startDateField = obj.getClass().getDeclaredField("startDate");
            Field endDateField = obj.getClass().getDeclaredField("endDate");

            startDateField.setAccessible(true);
            endDateField.setAccessible(true);

            LocalDate startDate = (LocalDate) startDateField.get(obj);
            LocalDate endDate = (LocalDate) endDateField.get(obj);

            if (startDate != null && endDate != null && endDate.isBefore(startDate)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                        .addPropertyNode("endDate")
                        .addConstraintViolation();
                return false;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Handle exception or rethrow it as runtime exception
            throw new RuntimeException("Erro ao acessar os campos de data", e);
        }
        return true;
    }
}
