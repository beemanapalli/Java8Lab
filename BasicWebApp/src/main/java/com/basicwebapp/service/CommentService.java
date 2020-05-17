package com.basicwebapp.service;

 

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basicwebapp.model.Comment;
import com.basicwebapp.model.repo.CommentRepository;

@Service
@Transactional(readOnly = true)
public class CommentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentService.class);
	
	private final CommentRepository  commentRepository ;
	
	public CommentService(CommentRepository commentRepository  ) {
		this.commentRepository = commentRepository;
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public List<Comment> saveAll(List<Comment> comments){
		LOGGER.info("Saving {}", comments);
		
		return commentRepository.saveAll(comments);
		
	}
	
	public List<Comment> getAllCommentsForToday(){
		
		LocalDate now =LocalDate.now();
		return commentRepository.findByCreatedYearAndMonthAndDay(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
		
	}

}
