package project.map.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.map.entity.UserEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	private String token ; // 토큰인증방식 사용시 사용될 토큰
	
	private Long idx; //식별자 
	private String userId; // 회원아이디
	private String password; // 비밀번호
	private String userName ; // 이름
	private String email; // 이메일
	private String address; // 주소 
	private String profilePhoto; // 프로필사진
	private Date birthDate; // 생년월일
	private Date signupDate; // 회원가입 날짜 
	
	
	
	
	public  UserDTO(UserEntity entity) {
		this.idx =entity.getIdx() ;
		this.userId = entity.getUserId() ;
		this.userName = entity.getUserName() ;
		this.email = entity.getEmail() ;
		this.birthDate = entity.getBirthDate();
		this.signupDate = entity.getSignupDate();
		this.address = entity.getAddress() ;
		this .profilePhoto = entity.getProfilePhoto() ;
	}
	
	
	
	
}

