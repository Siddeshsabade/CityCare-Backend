package com.citycare.dao;


import com.citycare.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueDao extends JpaRepository<Issue,Integer> {
}
