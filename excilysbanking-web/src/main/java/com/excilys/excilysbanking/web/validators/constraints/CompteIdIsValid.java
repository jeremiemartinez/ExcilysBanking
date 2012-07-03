
package com.excilys.excilysbanking.web.validators.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.excilys.excilysbanking.web.validators.CompteIdValidator;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompteIdValidator.class)
@Documented
public @interface CompteIdIsValid {

	String message() default "{com.excilys.excilysbanking.web.validators.constraints.compteidisvalid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
