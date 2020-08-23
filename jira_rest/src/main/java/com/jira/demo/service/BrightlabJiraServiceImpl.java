package com.jira.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;

@Service
public class BrightlabJiraServiceImpl implements BrightlabJiraService{
	
	private static final Logger log = LogManager.getLogger(BrightlabJiraServiceImpl.class);

	@Autowired
	JiraRestClient restClient;
	
	public String createIssue(String projectKey, Long issueType, String issueSummary) {
	    IssueRestClient issueClient = restClient.getIssueClient();
	    IssueInput newIssue = new IssueInputBuilder(
	      projectKey, issueType, issueSummary).build();
	    return issueClient.createIssue(newIssue).claim().getKey();
	}
	
	public void updateIssueDescription(String issueKey, String newDescription) {
	    IssueInput input = new IssueInputBuilder()
	      .setDescription(newDescription)
	      .build();
	    restClient.getIssueClient()
	      .updateIssue(issueKey, input)
	      .claim();
	}
	
	public Issue getIssue(String issueKey) {
	    return restClient.getIssueClient()
	      .getIssue(issueKey) 
	      .claim();
	}

	@Override
	public void displayIssue(Issue issue) {
		
		log.info("Issue details : {}", issue.getSummary());
	}
}
