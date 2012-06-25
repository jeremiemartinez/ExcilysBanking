
package com.excilys.excilysbanking.web.success;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.excilys.excilysbanking.services.UserService;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	// isAdmin?
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		if (userService.isAdmin(auth))
			response.sendRedirect("secured/admin/admin.html");
		else
			response.sendRedirect("secured/comptes.html");
	}
}
