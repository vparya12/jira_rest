package com.jira.demo.model;

public class JiraIssue {

	private String projecyKey;
	private String summary;
	private Long issueType;
	private String description;
	private String key;
	
	public String getProjecyKey() {
		return projecyKey;
	}
	public void setProjecyKey(String projecyKey) {
		this.projecyKey = projecyKey;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Long getIssueType() {
		return issueType;
	}
	public void setIssueType(Long issueType) {
		this.issueType = issueType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public JiraIssue(String projecyKey, String summary, Long issueType, String description, String key) {
		this.projecyKey = projecyKey;
		this.summary = summary;
		this.issueType = issueType;
		this.description = description;
		this.key = key;
	}
	
	public JiraIssue() {
		
	}
}
