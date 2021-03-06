package com.nineleaps.SpringBootDemo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nineleaps.SpringBootDemo.github.GithubClient;
import com.nineleaps.SpringBootDemo.github.RepositoryEvents;

@Component
public class GithubHealthIndicator implements HealthIndicator{
	
	private final GithubClient githubClient;
	
	
	
	public GithubHealthIndicator(GithubClient githubClient) {
		this.githubClient = githubClient;
	}



	@Override
	public Health health() {
		try {
			ResponseEntity<RepositoryEvents[]> response = this.githubClient.fetchEvents("spring-projects", "spring-boot");
			if(response.getStatusCode().is2xxSuccessful()) {
				return Health.up().build();
			}
			else {
				return Health.down().build();
			}
		}
		catch(Exception e) {
			return Health.down(e).build();
		}
	}

}
