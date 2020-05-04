package com.nineleaps.SpringBootDemo.events;

import java.util.List;

import com.nineleaps.SpringBootDemo.github.RepositoryEvents;

public class DashboardEntry {
	private final GithubProject project;

	private final List<RepositoryEvents> events;

	public DashboardEntry(GithubProject project, List<RepositoryEvents> events) {
		this.project = project;
		this.events = events;
	}

	public GithubProject getProject() {
		return project;
	}

	public List<RepositoryEvents> getEvents() {
		return events;
	}
}
