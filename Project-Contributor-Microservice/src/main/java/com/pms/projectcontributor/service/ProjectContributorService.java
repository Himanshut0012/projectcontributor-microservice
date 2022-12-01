package com.pms.projectcontributor.service;

import java.util.List;

import com.pms.projectcontributor.dto.ProjectContributorCreateDTO;
import com.pms.projectcontributor.dto.ProjectContributorsDTO;
import com.pms.projectcontributor.model.ProjectContributors;

public interface ProjectContributorService {
	
	public void addProjectContributor(ProjectContributors projectContributors);
	
	public List<ProjectContributorsDTO> getProjectContributorByProjectId(int projectId);
	
	public void deleteByContributorId(int contributorId);

	List<ProjectContributors> getAllContributors();

	void addAllContributor(List<ProjectContributorCreateDTO> projectContributorCreateDTOS);

	void deleteByProjectContributorId(int projectContributorId);

	List<ProjectContributors> getProjectContributors(int projectId);
}
