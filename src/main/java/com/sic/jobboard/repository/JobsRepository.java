package com.sic.jobboard.repository;

import com.sic.jobboard.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends CrudRepository<Job, Long> {
}
