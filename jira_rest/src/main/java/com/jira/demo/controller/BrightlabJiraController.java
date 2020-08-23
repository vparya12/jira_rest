package com.jira.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.jira.demo.model.CustomResponse;
import com.jira.demo.model.JiraIssue;
import com.jira.demo.service.BrightlabJiraService;

@RestController
@RequestMapping(value = "/brightlab")
public class BrightlabJiraController {
	
	private static final Logger log = LogManager.getLogger(BrightlabJiraController.class);

	@Autowired
	private BrightlabJiraService jiraService;
	
	@PostMapping(value = "/createIssue")
	public CustomResponse createJiraIssue(@RequestBody JiraIssue issue) {
		log.info("called to create new Issue");
		String key = jiraService.createIssue(issue.getProjecyKey(), issue.getIssueType(), issue.getSummary());
		return new CustomResponse(200, "Successfully created new jira issue with issue key " + key);
	}
	
	@PutMapping(value = "updateDescription")
	public CustomResponse updateJiraIssueDescription(@RequestBody JiraIssue issue) {
		log.info("called to update issue description");
		if(StringUtils.isEmpty(issue.getKey()))
			return new CustomResponse(400, "Invalid Issue Key");
		else
			jiraService.updateIssueDescription(issue.getKey(), issue.getDescription());
		return new CustomResponse(200, "Successfully updated description for issue key "+ issue.getKey());
		
	}
	
	@GetMapping(value = "getIssue/{issueKey}")
	public CustomResponse getJiraIssue(@PathVariable("issueKey") String issueKey) {
		log.info("called to get issue");
		Issue issue = jiraService.getIssue(issueKey);
		jiraService.displayIssue(issue);
		return new CustomResponse(200,"Success",issue.getSummary());
	}
}
