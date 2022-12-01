package com.pms.projectcontributor.service;

import java.util.List;

import com.pms.projectcontributor.dto.ProjectContributorCreateDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pms.projectcontributor.dao.ProjectContributorRepository;
import com.pms.projectcontributor.dto.ProjectContributorsDTO;
import com.pms.projectcontributor.model.ProjectContributors;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Component
public class ProjectContributorServiceImpl implements ProjectContributorService {


	private final ModelMapper modelMapper;
	private final ProjectContributorRepository projectContributorRepository;
	private final RestTemplate restTemplate;
	private final NameContributor nameContributor;
	
	
	@Override
	public void addProjectContributor(ProjectContributors projectContributors) {
		this.projectContributorRepository.save(projectContributors);
		
	}

	@Override
	public List<ProjectContributorsDTO> 	getProjectContributorByProjectId(int projectId) {
		
		List<ProjectContributors> projectContributors = this.projectContributorRepository.findByProjectId(projectId);
		List<ProjectContributorsDTO> projectContributorsDTOs = projectContributors.stream().map(projectContributor -> modelMapper.map(projectContributor, ProjectContributorsDTO.class)).toList();
		projectContributorsDTOs.forEach(contributor -> contributor.setContributorName(	nameContributor.getProjectContributorName(contributor.getContributorId())));
		return projectContributorsDTOs;
	}




	@Override
	public void deleteByContributorId(int contributorId) {
		ProjectContributors projectContributors = this.projectContributorRepository.findByContributorId(contributorId);
		this.projectContributorRepository.delete(projectContributors);
		
	}


	@Override
	public List<ProjectContributors> getAllContributors() {
		return this.projectContributorRepository.findAll();
	}

	@Override
	public void addAllContributor(List<ProjectContributorCreateDTO> projectContributorCreateDTOS) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ProjectContributors> projectContributors = projectContributorCreateDTOS.stream().map( contributor -> modelMapper.map( contributor,ProjectContributors.class)).toList();
		this.projectContributorRepository.saveAll(projectContributors);
	}

	@Override
	public void deleteByProjectContributorId(int projectContributorId) {
		this.projectContributorRepository.deleteById(projectContributorId);
	}

	@Override
	public List<ProjectContributors> getProjectContributors(int projectId) {
		return projectContributorRepository.findByProjectId(projectId);
	}


}
