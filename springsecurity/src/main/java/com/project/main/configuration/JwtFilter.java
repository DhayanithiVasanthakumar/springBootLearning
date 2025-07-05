package com.project.main.configuration;

import java.io.IOException;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.main.service.JwtService;
import com.project.main.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
//OncePerRequestFilter ->for every request filter oru thadava tha execute aagum
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;

	@Autowired
	// inthoda obj ah vachi bean ah yenga vena create panikalam
	ApplicationContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ipadi tha token irukum including space near Bearer
		// Bearer
		// eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhc3dpbmkiLCJpYXQiOjE3NTE2OTcxOTgsImV4cCI6MTc1MTY5NzMwNn0.SIoogp-QN9Nquh4GOo0m_R5F3erCBnvQYvs2du0o0uk

		// first request ta irunthu "Authorization" header ah vangidarom ,naraya headers
		// iruku ipothiki ithu pothum
		// intha header obj la token save aagidum
		String authorizationHeader = request.getHeader("Authorization");
		// token ooda last part mattu venum
		String token = null;
		String userName = null;

		// authurization header iruka nu check pananum
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			// (Bearer )->itha skip pananum so use substring to skip first 6 character
			// including space,so substring stats with 7
			token = authorizationHeader.substring(7);
			// to get user name in token
			userName = jwtService.extractUserName(token);

		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);

			// token validate aachi na next filter ku poganum athan
			// "UsernamePasswordAuthenticationFilter"
			if (jwtService.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				/*
				 * authToken ku UserDetails ah pathi theriyum aana request obj ah pathi
				 * theriyathu , so intha obj kum namaba request obj oda detais la theriya
				 * paduthanum
				 */
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				/*
				 * if statement la ithu null aha iruka nu paakum
				 * "SecurityContextHolder.getContext().getAuthentication()==null" apadi null ah
				 * irunntha "authToken" ooda details lam context ta save pananum
				 */
				SecurityContextHolder.getContext().setAuthentication(authToken);

			}
		}
		filterChain.doFilter(request, response);
	}

}
