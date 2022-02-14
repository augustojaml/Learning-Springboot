package com.springboot.nelioalves.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClientsUpdateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientsUpdate {
  String message() default "Validation Error";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}