package spring.planning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import spring.planning.dto.EmployeeDto;
import spring.planning.dto.LoginDto;
import spring.planning.dto.SignupDto;
import spring.planning.repository.RoleRepo;
import spring.planning.security.jwt.JwtUtils;
import spring.planning.security.services.UserDetailsImpl;
import spring.planning.service.AuthService;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("/planning/api/auth")
public class AuthController {
	
	@Autowired
	AuthService service;
	
	@Autowired
	AuthenticationManager authManager;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginRequest){

		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getShortname(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		String jwtToken = jwtUtils.generateJwtToken(userDetails);
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtToken).body(jwtToken);
}
	
	@PostMapping("/signup")
	public EmployeeDto signUp(@RequestBody SignupDto signupDto) throws Exception {
		return service.signup(signupDto);
	}

}
