package com.cts.Insured.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.Insured.Entities.ClaimDetails;

@Repository
public interface ClaimDetailsRepo extends JpaRepository<ClaimDetails, Integer>  {
}
