package com.flipkartclone.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkartclone.admin.model.Admin;
import com.flipkartclone.admin.service.AdminService;
import com.flipkartclone.admin.util.JwtUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	private AdminService adminService;
	
	public AdminController (AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@PostMapping("/auth")
    public String generateToken(@RequestBody Admin admin) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(admin.getEmail(), admin.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(admin.getEmail());
    }
	
	
	
	
	@GetMapping("/alladmins")
	public ResponseEntity<List<Admin>> getAllAdmins(){ 
		return new ResponseEntity<List<Admin>>((List<Admin>)adminService.getAllAdmins(), HttpStatus.OK);

}
}