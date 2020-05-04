package com.nineleaps.SpringBootDemo.events;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nineleaps.SpringBootDemo.github.GithubClient;
import com.nineleaps.SpringBootDemo.github.RepositoryEvents;

@Controller
public class EventsController {
	
	private final GithubProjectRepository repository;
	
	private final GithubClient githubClient;
	
	public EventsController(GithubProjectRepository repository, GithubClient githubClient) {
		this.repository = repository;
		this.githubClient = githubClient;
	}



	@GetMapping("/events/{repoName}")
	@ResponseBody
	public RepositoryEvents[] fetchEvents(@PathVariable String repoName) {
		GithubProject project = this.repository.findByRepoName(repoName);
		
		return this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
	}
}
