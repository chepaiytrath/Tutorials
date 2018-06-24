package com.demo.bs.project.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.demo.bs.project.domain.Team;

@RepositoryRestResource(path = "teams", collectionResourceRel = "teams")
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {

}