package com.dichvudulich.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dichvudulich.FileEntity.DatabaseFileService;
import com.dichvudulich.FileEntity.FileInfo;
import com.dichvudulich.FileEntity.FilesStorageService;
import com.dichvudulich.FileEntity.ResponseMessage;
import com.dichvudulich.entity.DatabaseFile;
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
	
	@Autowired
	private FilesStorageService storageService;
	
	@Autowired
	private DatabaseFileService fileStorageService;

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
		loaitour.setTrangthai(true);
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
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.save(file);
			DatabaseFile fileName = fileStorageService.storeFile(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
					.path(fileName.getFileName()).toUriString();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {
		List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(LoaiTourController.class, "getFile", path.getFileName().toString()).build().toString();

			return new FileInfo(filename, url);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

}
