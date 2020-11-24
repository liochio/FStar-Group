package com.dichvudulich.api;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dichvudulich.entity.ERole;
import com.dichvudulich.entity.LoaitourEntity;
import com.dichvudulich.entity.RolesEntity;
import com.dichvudulich.entity.UsersEntity;
import com.dichvudulich.repository.LoaiTourRepository;
import com.dichvudulich.repository.RolesRepository;
import com.dichvudulich.repository.UsersRepository;
import com.dichvudulich.request.LoaiTourEntityRequest;
import com.dichvudulich.request.SignupRequest;
import com.dichvudulich.response.MessageResponse;
import com.dichvudulich.ultil.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoaiTourController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	LoaiTourRepository loaiTourRepository;

	@Autowired
	RolesRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/loaitour")
	public ResponseEntity<?> createLoaitour(@Valid @RequestBody LoaiTourEntityRequest loaiTourEntityRequest) {
		
		LoaitourEntity loaitour = new LoaitourEntity(loaiTourEntityRequest.getMaloaitour(),
				loaiTourEntityRequest.getTenloaitour(), loaiTourEntityRequest.getTrangthai());
		loaiTourRepository.save(loaitour);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
