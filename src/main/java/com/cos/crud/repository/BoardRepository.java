package com.cos.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cos.crud.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	//update 할 때는 Transactional + Modifying
	//delete 할 때는 Transactional
	//insert 할 때는 Transactional
	@Transactional
	@Modifying
	@Query(value="UPDATE board SET count=count+1 WHERE id=?1",nativeQuery = true)
	public void increaseCount(int id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE board SET createDate=now() WHERE id=?1",nativeQuery = true)
	public void timeUpdate(int id);
}
