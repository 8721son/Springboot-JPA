package com.cos.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.crud.model.User;

// CRUD를 구현해주는 클래스 JpaRepository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmailAndPassword(String email,String password);
		
//	@Transactional
//	@Modifying
//	@Query(value="UPDATE user SET role =?1 WHERE id=?2",nativeQuery = true)
//	public void updateRole(String role,int id);
}
