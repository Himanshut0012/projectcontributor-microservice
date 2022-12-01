package com.pms.projectcontributor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.projectcontributor.model.ProjectContributors;


@Repository
public interface ProjectContributorRepository extends JpaRepository<ProjectContributors, Integer> {

	public List<ProjectContributors> findByProjectId(int projectId);
	
	public void deleteByContributorId(int contributorId);
	
	public ProjectContributors findByContributorId( int contributorId);
	
}
