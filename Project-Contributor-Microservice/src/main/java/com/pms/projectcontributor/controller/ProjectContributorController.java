package com.pms.projectcontributor.controller;

import java.util.ArrayList;
import java.util.List;

import com.pms.projectcontributor.dto.ProjectContributorCreateDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.pms.projectcontributor.dto.ProjectContributorsDTO;
import com.pms.projectcontributor.model.ProjectContributors;
import com.pms.projectcontributor.service.ProjectContributorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/v1/contributor")
public class ProjectContributorController {
	
	private final ProjectContributorService projectContributorService;
	
	
	@PostMapping("/")
	public void addProjectContributor(@RequestBody ProjectContributors projectContributors) {
		this.projectContributorService.addProjectContributor(projectContributors);
	}
	
	@GetMapping("/{projectId}")
//	@CircuitBreaker(name = "EMPLOYEE_SERVICE",fallbackMethod = "getFallBackProjectContributorName")
	public List<ProjectContributorsDTO> getProjectContributorByProjectId(@PathVariable int projectId){
		return this.projectContributorService.getProjectContributorByProjectId(projectId);
	}

	public List<ProjectContributorsDTO> getFallBackProjectContributorName(@PathVariable int projectId,  java.lang.Throwable t){
		List<ProjectContributorsDTO> projectContributorsDTOS=new ArrayList<>();

		return projectContributorsDTOS;
	}

	@GetMapping("/getProjectContributors/{projectId}")
	public List<ProjectContributors> getProjectContributors(@PathVariable int projectId){
		return this.projectContributorService.getProjectContributors(projectId);
	}
	
	
	@DeleteMapping("/{contributorId}")
	public void deleteByContributorId(@RequestParam int contributorId) {
		this.projectContributorService.deleteByContributorId(contributorId);
	}
	@DeleteMapping("/delete/{projectContributorId}")
	public void deleteByProjectContributorId(@PathVariable int  projectContributorId){
		this.projectContributorService.deleteByProjectContributorId(projectContributorId);
	}

	@PostMapping(value = "/addAll",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllContributor(@RequestBody List<ProjectContributorCreateDTO> projectContributorCreateDTOS){
		this.projectContributorService.addAllContributor(projectContributorCreateDTOS);
	}

	@GetMapping("/")
	public List<ProjectContributors> getAllContributors(){
		return this.projectContributorService.getAllContributors();
	}

}
