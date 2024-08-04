package br.com.ruderson.portfolio_restful.validations;

import br.com.ruderson.portfolio_restful.DTO.ExperienceDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, ExperienceDTO> {

    @Override
    public boolean isValid(ExperienceDTO dto, ConstraintValidatorContext context) {
        if (dto.getStartDate() != null && dto.getEndDate() != null) {
            if (dto.getEndDate().isBefore(dto.getStartDate())) {
                context.buildConstraintViolationWithTemplate("Data final deve ser maior que data inicial")
                        .addPropertyNode("endDate")
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}
