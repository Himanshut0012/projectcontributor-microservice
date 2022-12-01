package com.pms.projectcontributor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectContributors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectContributorId;
	private Integer projectId;
	private Integer contributorId;
    private String createdBy;
    private Date createdDate;
    private String lastUpdatedBy;
    private Date lastUpdatedDate;
    private String recordStatus;

}
