package com.basicwebapp.test.mockito.model.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import com.basicwebapp.model.Comment;
import com.basicwebapp.model.CommentType;
import com.basicwebapp.model.repo.CommentRepository;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@MockBean(CommentRepository.class)
public class CommentRepoTest {
	
/*
	@Autowired
	CommentRepository componentRepo;
	*/
	@Mock
	CommentRepository componentRepo;
	
	@Test
    public void findByCreatedYearAndMonthAndDay_HappyPath_ShouldReturn1Comment() {
	Comment comment =new Comment();
	comment.setComment("TestComment");
	comment.setType(CommentType.PLUS);
	comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
    List<Comment> commentlist =new ArrayList<>();
    commentlist.add(comment);
	
	
	LocalDate now = LocalDate.now();
 
	when(componentRepo.findByCreatedYearAndMonthAndDay(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth())).thenReturn(commentlist);
	List<Comment> comments = componentRepo.findByCreatedYearAndMonthAndDay(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth());
	
	assertThat(comments).hasSize(1);
	assertThat(comments.get(0)).hasFieldOrPropertyWithValue("comment","TestComment" );
	
	
	
	}
	

}
