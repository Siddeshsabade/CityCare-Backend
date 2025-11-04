package com.citycare.Controller;

import com.citycare.model.Issue;
import com.citycare.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/issue")
@RestController
@CrossOrigin(origins = "https://citycare-siddesh.netlify.app")

public class IssueController {

    @Autowired
    private IssueService issueService;
    @PostMapping("/create")
    public Issue createIssue(@RequestBody Issue issue){
        return issueService.createIssue(issue);
    }

    @GetMapping("/all")
    public List<Issue> getAll(){
        return issueService.getallIssues();
    }

    @GetMapping("/{id}")
    public Issue getIssueById(@PathVariable int id){
        return issueService.getIssueById(id);
    }

    @PutMapping("/update/{id}")
    public Issue updateIssue(@PathVariable int id, @RequestBody Issue issue) {
        return issueService.updateIssue(id, issue);
    }

    @DeleteMapping("/delete/{id}")
            public String deleteIssueById(@PathVariable Integer id){
                return issueService.deleteIssueById(id);

            }
}




