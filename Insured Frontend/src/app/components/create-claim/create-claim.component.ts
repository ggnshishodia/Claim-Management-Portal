import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../../data.service';

@Component({
  selector: 'app-create-claim',
  templateUrl: './create-claim.component.html',
  styleUrls: ['./create-claim.component.css'],
  providers: [DataService],
})
export class CreateClaimComponent {
  claimForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private dataService: DataService
  ) {
    this.claimForm = this.formBuilder.group({
      policyNo: ['', Validators.required],
      estimatedLoss: ['', [Validators.required, Validators.min(0)]],
      dateOfAccident: ['', Validators.required],
      claimStatus: ['', Validators.required],
      amtApprovedBySurveyor: ['', Validators.required], 
      withDrawClaim: ['', Validators.required],
      surveyorFee: ['', Validators.required],
      insuranceCompanyApproval: ['', Validators.required], 
    });
  }

  onSubmit(): void {
    if (this.claimForm.invalid) {
      return;
    }

    const claimData = this.claimForm.value;
    console.log(claimData);
    this.http
      .post('http://localhost:8080/api/claims/addClaim', claimData)
      .subscribe(
        (response) => {
          // Handle success response
          console.log('Claim added successfully');
        },
        (error) => {
          // Handle error response
          console.error('Failed to add claim', error);
        }
      );
  }
}
