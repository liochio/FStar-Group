package com.dichvudulich.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dichvudulich.entity.LoaitourEntity;
import com.dichvudulich.repository.LoaiTourRepository;
import com.dichvudulich.repository.RolesRepository;
import com.dichvudulich.repository.UsersRepository;
import com.dichvudulich.request.LoaiTourEntityRequest;
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

	@GetMapping("/loaitour/{id}")
	public ResponseEntity<Optional<LoaitourEntity>> getEmployeeById(@PathVariable Long id) {
		Optional<LoaitourEntity> user = loaiTourRepository.findById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/loaitour")
	public List<LoaitourEntity> findAll() {

		return (List<LoaitourEntity>) this.loaiTourRepository.findAll();

	}

	@PostMapping("/loaitour")
	public ResponseEntity<?> createLoaitour(@Valid @RequestBody LoaiTourEntityRequest loaiTourEntityRequest) {

		LoaitourEntity loaitour = new LoaitourEntity(loaiTourEntityRequest.getMaloaitour(),
				loaiTourEntityRequest.getTenloaitour(), loaiTourEntityRequest.getTrangthai());
		loaiTourRepository.save(loaitour);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@PutMapping("/loaitour/{id}")
	public ResponseEntity<LoaitourEntity> updateTutorial(@PathVariable("id") long id,
			@RequestBody LoaitourEntity tutorial) {
		LoaitourEntity entity = loaiTourRepository.findById(id);
		entity.setMaloaitour(tutorial.getMaloaitour());
		entity.setTenloaitour(tutorial.getTenloaitour());
		entity.setTrangthai(tutorial.getTrangthai());
		return new ResponseEntity<>(loaiTourRepository.save(entity), HttpStatus.OK);

	}

	@DeleteMapping("/loaitour/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			loaiTourRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
