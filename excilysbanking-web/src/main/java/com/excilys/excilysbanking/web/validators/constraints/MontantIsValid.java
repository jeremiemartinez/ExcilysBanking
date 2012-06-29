
package com.excilys.excilysbanking.web.validators.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.excilys.excilysbanking.web.validators.MontantValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MontantValidator.class)
@Documented
public @interface MontantIsValid {

	String message() default "Montant is not valid: either Montant is not filled or is greater than solde available...";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
