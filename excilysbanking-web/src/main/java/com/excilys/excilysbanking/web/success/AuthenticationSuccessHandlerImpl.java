
package com.excilys.excilysbanking.web.success;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.excilys.excilysbanking.entities.Authority;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		for (GrantedAuthority a : auth.getAuthorities()) {
			if (a.getAuthority().equals(Authority.AuthorityType.ROLE_ADMIN.name())) {
				response.sendRedirect("secured/admin/admin.html");
				return;
			}
		}
		response.sendRedirect("secured/comptes.html");
	}
}
