package com.basicwebapp.test.model.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.basicwebapp.model.Comment;
import com.basicwebapp.model.CommentType;
import com.basicwebapp.model.repo.CommentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepoTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private CommentRepository commentRepository;
	@Test
    public void findByCreatedYearAndMonthAndDay_HappyPath_ShouldReturn1Comment() {
	Comment comment =new Comment();
	comment.setComment("TestComment");
	comment.setType(CommentType.PLUS);
	comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
	testEntityManager.persist(comment);
	testEntityManager.flush();
	
	
	LocalDate now = LocalDate.now();
	
	List<Comment> comments = commentRepository.findByCreatedYearAndMonthAndDay(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth());
	
	assertThat(comments).hasSize(1);
	assertThat(comments.get(0)).hasFieldOrPropertyWithValue("comment","TestComment" );
	
	
	
	}
	

}
