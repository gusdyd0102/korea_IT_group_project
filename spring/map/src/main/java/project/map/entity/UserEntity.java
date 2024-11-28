package project.map.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idx; //식별자 
	private String userId; // 회원아이디
	private String password; // 비밀번호
	private String userName ; // 이름
	private String email; // 이메일
	private String address; // 주소 
	private String profilePhoto; // 프로필사진
	private String authProvider ; // 소셜로그인공급자 
	private Date birthDate; // 생년월일
	@CreationTimestamp
	private Date signupDate; // 회원가입 날짜 
}
