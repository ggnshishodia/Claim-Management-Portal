package com.cts.Insured;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import com.cts.Insured.Entities.ClaimDetails;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.Insured.Repositories.ClaimDetailsRepo;
import com.cts.Insured.Service.ClaimDetailsService;

@SpringBootTest
class InsuredApplicationTests {

	@Mock
    private ClaimDetailsRepo claimDetailsRepo;

    @InjectMocks
    private ClaimDetailsService claimService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddClaim() throws Exception {
  
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("23/06/2023");
        ClaimDetails claimDetails = new ClaimDetails();
        claimDetails.setInsuranceCompanyApproval(false);
        claimDetails.setAmtApprovedBySurveyor(2000);
        claimDetails.setClaimStatus(true);
        claimDetails.setDateOfAccident(d);
        claimDetails.setSurveyorFee(300);
        claimDetails.setPolicyNo("12");
        claimDetails.setWithDrawClaim(false);
        claimDetails.setEstimatedLoss(3000);

        Mockito.when(claimDetailsRepo.save(Mockito.any(ClaimDetails.class))).thenReturn(claimDetails);

        // Act
        int claimId = claimService.addClaim(claimDetails);

        // Assert
        Assertions.assertEquals(claimDetails.getClaimId(), claimId, "Claim ID should match");

        // Optionally, verify that the save method was called with the correct argument
        Mockito.verify(claimDetailsRepo).save(Mockito.any(ClaimDetails.class));
    }
    
    @Test
    public void testRequestClaim_Withdrawn() {
        // Arrange
        int claimId = 1;
        int expectedAmt = 5000;

        ClaimDetails claim = new ClaimDetails();
        claim.setAmtApprovedBySurveyor(2000);

        Optional<ClaimDetails> optionalClaim = Optional.of(claim);
        Mockito.when(claimDetailsRepo.findById(claimId)).thenReturn(optionalClaim);

        // Act
        claimService.requestClaim(claimId, expectedAmt);

        // Assert
        Assertions.assertTrue(claim.isWithDrawClaim(), "Claim should be withdrawn");
        Assertions.assertFalse(claim.isClaimStatus(), "Claim status should be false");

        // Optionally, verify that the save method was called with the correct argument
        Mockito.verify(claimDetailsRepo).save(claim);
    }
    
    @Test
    public void testRequestClaim_Accepted() {
        // Arrange
        int claimId = 1;
        int expectedAmt = 1500;

        ClaimDetails claim = new ClaimDetails();
        claim.setAmtApprovedBySurveyor(2000);

        Optional<ClaimDetails> optionalClaim = Optional.of(claim);
        Mockito.when(claimDetailsRepo.findById(claimId)).thenReturn(optionalClaim);

        // Act
        claimService.requestClaim(claimId, expectedAmt);

        // Assert
        Assertions.assertFalse(claim.isWithDrawClaim(), "Claim should not be withdrawn");
        Assertions.assertFalse(claim.isClaimStatus(), "Claim status should be false");

        // Optionally, verify that the save method was called with the correct argument
        Mockito.verify(claimDetailsRepo).save(claim);
    }
}

