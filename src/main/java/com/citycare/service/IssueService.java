package com.citycare.service;

import com.citycare.dao.IssueDao;
import com.citycare.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {

  @Autowired
  private IssueDao issuedao;
  public Issue createIssue(Issue issue){
      return issuedao.save(issue);
  }

  public List<Issue> getallIssues(){
      return issuedao.findAll();
    }

  public Issue getIssueById(Integer id){
      return issuedao.findById(id).orElse(null);
  }



    public Issue updateIssue(int id, Issue newIssue) {
        Optional<Issue> existing = issuedao.findById(id);
        if (existing.isPresent()) {
            Issue issue = existing.get();
            issue.setTitle(newIssue.getTitle());
            issue.setDescription(newIssue.getDescription());
            issue.setCategory(newIssue.getCategory());
            issue.setStatus(newIssue.getStatus());
            issue.setCreatedAt(newIssue.getCreatedAt());
            issue.setAssignedTo(newIssue.getAssignedTo());
            issue.setLatitude(newIssue.getLatitude());
            issue.setLongitude(newIssue.getLongitude());

//            issue.setImages(issue.getImages());
            return issuedao.save(issue);
        }
        return null;
    }

    public String deleteIssueById(Integer id){
             issuedao.deleteById(id);
             return "Issue deleted successfully";
    }


    }


