package com.learn.springboot.crud.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(generator = "custom")
	@SequenceGenerator(initialValue = 10001, allocationSize = 1, name = "custom")
	private long id;
	private String name;
	private long number;
	private String gender;
	private double maths;
	private double science;
	private double english;
	@CreationTimestamp
	private Date detailCreationTime;
	@UpdateTimestamp
	private Date detailLastUpdatedTime;
}
