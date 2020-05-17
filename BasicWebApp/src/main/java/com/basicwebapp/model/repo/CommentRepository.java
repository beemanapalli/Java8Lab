package com.basicwebapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.basicwebapp.model.*;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	@Query
	(value="SELECT c.* FROM Comment c WHERE year(c.CREATEDDATE) = ?1 AND month(c.CREATEDDATE) = ?2 AND day(c.CREATEDDATE) = ?3",nativeQuery = true)
	List<Comment> findByCreatedYearAndMonthAndDay(int year, int month, int day);
}
