package com.nineleaps.SpringBootDemo;

import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("github")
@Validated
public class GithubProperties {
	/**
	 * 
	 * GitHub API token ("user:sampletoken")
	 */
	@Pattern(regexp = "\\w+:\\w+")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
