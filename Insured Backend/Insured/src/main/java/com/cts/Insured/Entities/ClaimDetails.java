package com.cts.Insured.Entities;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="claimdetails")
public class ClaimDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int claimId;
	
	@Column(name="policyNo")
	private String policyNo;
	
	@Column(name="estimatedLoss")
	private int estimatedLoss;
	
	@Column(name="dateOfAccident")
	private Date dateOfAccident;
	
	@Column(name="claimStatus")
	private boolean claimStatus;
	
	@Column(name="amtApprovedBySurveyor")
	private int amtApprovedBySurveyor;
	
	@Column(name="insuranceCompanyApproval")
	private boolean InsuranceCompanyApproval;
	
	@Column(name="withDrawClaim")
	private boolean withDrawClaim;
	
	@Column(name="surveyorFee")
	private int surveyorFee;

	public ClaimDetails(int claimId, String policyNo, int estimatedLoss, Date dateOfAccident, boolean claimStatus,
			int amtApprovedBySurveyor, boolean insuranceCompanyApproval, boolean withDrawClaim, int surveyorFee) {
		super();
		this.claimId = claimId;
		this.policyNo = policyNo;
		this.estimatedLoss = estimatedLoss;
		this.dateOfAccident = dateOfAccident;
		this.claimStatus = claimStatus;
		this.amtApprovedBySurveyor = amtApprovedBySurveyor;
		InsuranceCompanyApproval = insuranceCompanyApproval;
		this.withDrawClaim = withDrawClaim;
		this.surveyorFee = surveyorFee;
	}

	public ClaimDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public int getEstimatedLoss() {
		return estimatedLoss;
	}

	public void setEstimatedLoss(int estimatedLoss) {
		this.estimatedLoss = estimatedLoss;
	}

	public Date getDateOfAccident() {
		return dateOfAccident;
	}

	public void setDateOfAccident(Date d) {
		this.dateOfAccident = d;
	}

	public boolean isClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(boolean claimStatus) {
		this.claimStatus = claimStatus;
	}

	public int getAmtApprovedBySurveyor() {
		return amtApprovedBySurveyor;
	}

	public void setAmtApprovedBySurveyor(int amtApprovedBySurveyor) {
		this.amtApprovedBySurveyor = amtApprovedBySurveyor;
	}

	public boolean isInsuranceCompanyApproval() {
		return InsuranceCompanyApproval;
	}

	public void setInsuranceCompanyApproval(boolean insuranceCompanyApproval) {
		InsuranceCompanyApproval = insuranceCompanyApproval;
	}

	public boolean isWithDrawClaim() {
		return withDrawClaim;
	}

	public void setWithDrawClaim(boolean withDrawClaim) {
		this.withDrawClaim = withDrawClaim;
	}

	public int getSurveyorFee() {
		return surveyorFee;
	}

	public void setSurveyorFee(int surveyorFee) {
		this.surveyorFee = surveyorFee;
	}
	
	
}
