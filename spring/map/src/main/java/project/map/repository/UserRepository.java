package project.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.map.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserId(String userId); 
	// 아이디 통해 entity 반환

	boolean existsByUserId(String userId); 
	// 아이디가 존재하면 true , 존재하지 않으면false 반환 id중복체크?

	UserEntity findByUserIdAndPassword(String userId, String password);
	// userName , password를 통해 두필드를 모두 만족하는 데이터를 찾는 조건의쿼리생성.


}
