package com.dichvudulich.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dichvudulich.entity.Dattour;
import com.dichvudulich.entity.TourEntity;
import com.dichvudulich.repository.DattourRepository;
import com.dichvudulich.repository.RolesRepository;
import com.dichvudulich.request.DattourEntityRequest;
import com.dichvudulich.response.MessageResponse;
import com.dichvudulich.ultil.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class DattourController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	DattourRepository dattourRepository;

	@Autowired
	RolesRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping(value = "/dattour")
	public List<Dattour> findAll() {

		return (List<Dattour>) this.dattourRepository.findAll();

	}
	
	@GetMapping("/dattour/{id}")
	public ResponseEntity<Optional<Dattour>> getTourById(@PathVariable Long id) {
		Optional<TourEntity> tourEntity = dattourRepository.findById(id);
		return ResponseEntity.ok(tourEntity);
	}

	@PostMapping("/dattour")
	public ResponseEntity<?> createDattour(@Valid @RequestBody DattourEntityRequest dattourEntityRequest) {
		TourEntity tour = new TourEntity();
		Dattour tourEntity = new Dattour(dattourEntityRequest.getTenloaitour(), dattourEntityRequest.getHinhanh(),
				dattourEntityRequest.getThoigiankhoihanh(), dattourEntityRequest.getThoigiandat(),
				dattourEntityRequest.getSoluongkhach(), dattourEntityRequest.getTenloaidichvu(),
				dattourEntityRequest.getTenkhachhang(), dattourEntityRequest.getGhichu(),
				dattourEntityRequest.getTongtien(), dattourEntityRequest.getTrangthai());
		tourEntity.setSoluongkhach(tour.getSoluongkhach());
		tourEntity.setThoigiankhoihanh(new Date());
		tourEntity.setThoigiandat(new Date());
		tourEntity.setTrangthai(true);
		dattourRepository.save(tourEntity);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
