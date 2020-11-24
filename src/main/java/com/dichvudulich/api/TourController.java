package com.dichvudulich.api;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dichvudulich.entity.TourEntity;
import com.dichvudulich.repository.LoaiTourRepository;
import com.dichvudulich.repository.RolesRepository;
import com.dichvudulich.repository.TourRepository;
import com.dichvudulich.repository.UsersRepository;
import com.dichvudulich.request.TourEntityRequest;
import com.dichvudulich.response.MessageResponse;
import com.dichvudulich.ultil.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class TourController {

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

	@Autowired
	TourRepository tourRepository;

	@GetMapping("/tour/{id}")
	public ResponseEntity<Optional<TourEntity>> getTourById(@PathVariable Long id) {
		Optional<TourEntity> tourEntity = tourRepository.findById(id);
		return ResponseEntity.ok(tourEntity);
	}

	@GetMapping(value = "/tour")
	public List<TourEntity> findAll() {

		return (List<TourEntity>) this.tourRepository.findAll();

	}

	@PostMapping("/tour")
	public ResponseEntity<?> createTour(@Valid @RequestBody TourEntityRequest tourEntityRequest) {

		TourEntity tourEntity = new TourEntity(tourEntityRequest.getMota(), tourEntityRequest.getMotachitiet(),
				tourEntityRequest.getHinhanh(), tourEntityRequest.getGia(), tourEntityRequest.getDiadiem(),
				tourEntityRequest.getThoigiankhoihanh(), tourEntityRequest.getSoluongkhach(),
				tourEntityRequest.getTrangthai());
		tourEntity.setThoigiankhoihanh(new Date());
		tourEntity.setTrangthai(true);
		tourRepository.save(tourEntity);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@DeleteMapping("/tour/{id}")
	public ResponseEntity<HttpStatus> deleteTour(@PathVariable("id") long id) {
		try {
			tourRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
