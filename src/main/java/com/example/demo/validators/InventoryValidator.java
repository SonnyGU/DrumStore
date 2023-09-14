package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        // Initialization code, if any
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) {
            return true;
        }

        if (part.getInv() - 1 < part.getMinInv()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Inventory is less than the allowed minimum.")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            return false;
        }

        if (part.getInv() > part.getMaxInv()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Inventory exceeds the allowed maximum.")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}