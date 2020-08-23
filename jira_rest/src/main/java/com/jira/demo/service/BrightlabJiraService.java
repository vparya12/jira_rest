package com.jira.demo.service;

import com.atlassian.jira.rest.client.api.domain.Issue;

public interface BrightlabJiraService {
	public String createIssue(String projectKey, Long issueType, String issueSummary);
	
	public void updateIssueDescription(String issueKey, String newDescription);
	    
	public Issue getIssue(String issueKey);
	
	public void displayIssue(Issue issue);
	   
}
