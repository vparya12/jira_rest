package com.jira.demo.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

@Configuration
public class MyJiraRestClient {

	@Value("${jira.username}")
	private String userName;
	@Value("${jira.password}")
	private String password;
	@Value("${jira.url}")
	private String jiraUrl;

	private URI getJiraUri() {
		return URI.create(this.jiraUrl);
	}
	
	@Bean
	public JiraRestClient getJiraRestClient() {
	    return new AsynchronousJiraRestClientFactory()
	      .createWithBasicHttpAuthentication(getJiraUri(), this.userName, this.password);
	}
	
	
	
	
}
