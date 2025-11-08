package com.cts.Insured.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cts.Insured.Entities.ClaimDetails;
import com.cts.Insured.Repositories.ClaimDetailsRepo;
import com.cts.Insured.Service.ClaimDetailsService;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin(origins = "http://localhost:4200")
public class InsuredController {
	
	@Autowired
	private ClaimDetailsService claimDetailsService;
	
	@Autowired
	private ClaimDetailsRepo claimdetailsRepo;
	
	@CrossOrigin
	@PutMapping("/{claimID}")
	public ResponseEntity<ClaimDetails> updateClaim(@PathVariable int claimID, @RequestBody ClaimDetails updatedClaim){
		Optional<ClaimDetails> claim1 = claimdetailsRepo.findById(claimID);
		ClaimDetails claim = claim1.get();

        if (claim != null) {
            claim.setWithDrawClaim(updatedClaim.isWithDrawClaim());
            claim.setClaimStatus(updatedClaim.isClaimStatus());
            ClaimDetails clm = claimdetailsRepo.save(claim);
            return ResponseEntity.ok(clm);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@CrossOrigin
	@PostMapping("/addClaim")
	public ResponseEntity<Integer> addClaim(@RequestBody ClaimDetails claim) throws Exception{
		int claimId = this.claimDetailsService.addClaim(claim);
		return ResponseEntity.ok(claimId);
	}
	
	@CrossOrigin
	@GetMapping("/ok/{id}")
	public ResponseEntity<ClaimDetails> getBill(@PathVariable("id") int id) {	
		
		Optional<ClaimDetails> bill =  this.claimdetailsRepo.findById(id);
		ClaimDetails claim = bill.get();
		if(bill==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(claim));
	}
	
	

}
