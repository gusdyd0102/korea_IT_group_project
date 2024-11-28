package project.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.map.dto.ResponseDTO;
import project.map.dto.UserDTO;
import project.map.service.UserService;

@RequestMapping
@Slf4j
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	// 유저전체 조회
	@GetMapping
	public ResponseEntity<?> retrieve(){
		List<UserDTO> dtos = service.getAll();
		ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().data(dtos).build() ;
		return ResponseEntity.ok(response) ;
	}
	
	
	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO dto) {
		UserDTO registerUser = service.create(dto) ;
		ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().value(registerUser).build() ;
		return ResponseEntity.ok(response) ;
	}
	
	// 로그인 
	@PostMapping("/signin")
	public ResponseEntity<?> authenticate(@RequestBody UserDTO dto) {
		UserDTO user = service.getByCredentials(dto.getUserId(), dto.getPassword());
		if (user != null) {

			ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().value(user).build() ;
			return ResponseEntity.ok(response) ;

		} else {
			ResponseDTO responseDTO = ResponseDTO.builder().error("Login failed").build();
			return ResponseEntity.badRequest().body(responseDTO);

		}

	}
	
	// 중복체크
	@PostMapping
	public ResponseEntity<?> duplicate(@RequestBody UserDTO dto) {
		return ResponseEntity.ok(service.duplicate(dto.getUserId())) ;
	}
	

	
	
	
	
	
	
	
	
}

