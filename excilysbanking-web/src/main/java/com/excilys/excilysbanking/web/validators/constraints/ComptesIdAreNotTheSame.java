
package com.excilys.excilysbanking.web.validators.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.excilys.excilysbanking.web.validators.SameIdComptesValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameIdComptesValidator.class)
@Documented
public @interface ComptesIdAreNotTheSame {

	String message() default "Comptes Id are the same...";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}