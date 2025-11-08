package com.cts.Insured.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Insured.Entities.ClaimDetails;
import com.cts.Insured.Repositories.ClaimDetailsRepo;

@Service
public class ClaimDetailsService {

	private ClaimDetailsRepo claimdetailsRepo;

	@Autowired
	public ClaimDetailsService(ClaimDetailsRepo claimdetailsRepo) {
		super();
		this.claimdetailsRepo = claimdetailsRepo;
	}

	public void requestClaim(int claimId, int expectedAmt) {
		Optional<ClaimDetails> claim_t = claimdetailsRepo.findById(claimId);
		ClaimDetails claim = claim_t.get();

		if (claim.getAmtApprovedBySurveyor() < expectedAmt) {
			claim.setWithDrawClaim(true);
			claim.setClaimStatus(false);

			System.out.println("Claim is WithDrawn");
		} else {
			claim.setWithDrawClaim(false);
			claim.setClaimStatus(false);

			System.out.println("Claim Amount Accepted");
		}

		claimdetailsRepo.save(claim);
	}

	public int addClaim(ClaimDetails claim) throws Exception {
		ClaimDetails claim1 = claimdetailsRepo.save(claim);
		return claim1.getClaimId();
	}
}
