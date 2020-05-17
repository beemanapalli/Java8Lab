package com.basicwebapp.model;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Table(name="comment")
@EntityListeners(AuditingEntityListener.class)
@Data
@Access(value=AccessType.FIELD)
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	
	private String comment;
	
	@Enumerated(EnumType.STRING)
	private CommentType type;
	
	@CreatedDate
	@Column(name = "CREATEDDATE")
	private Timestamp createdDate;
	
	@CreatedBy
	private String createdBy;
}
