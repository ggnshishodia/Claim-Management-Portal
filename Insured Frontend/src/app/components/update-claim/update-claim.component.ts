import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../../data.service';
import { Data } from '../../Data';

@Component({
  selector: 'app-update-claim',
  templateUrl: './update-claim.component.html',
  styleUrls: ['./update-claim.component.css'],
  providers: [DataService],
})
export class UpdateClaimComponent implements OnInit {
  claimId!: number;
  data: Data | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private http: HttpClient,
    private dataService: DataService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.claimId = params['claimId'];
    });
  }

  onSubmit(): void {
    this.dataService.getClaimDetails(this.claimId).subscribe((claim: any) => {
      this.data = claim;
    });
  }

  acceptClaim(): void {
    if (this.data) {
      this.data.claimStatus = true;
      this.data.withDrawClaim = false;
      this.updateClaim(this.data);
    }
    console.log(this.data);
  }

  withdrawClaim(): void {
    if (this.data) {
      this.data.withDrawClaim = true;
      this.data.claimStatus = false;
      this.updateClaim(this.data);
    }
    console.log(this.data);
  }

  closeClaim(): void {
    if (this.data) {
      this.data.claimStatus = false;
      this.updateClaim(this.data);
    }
    console.log(this.data);
  }

  private updateClaim(data: any): void {
    this.dataService.updateClaim(this.claimId, data).subscribe(
      (response) => {
        console.log('Claim updated successfully', response.data);
        // Update the claim status in the local data object
      },
      (error) => {
        // Handle error response
        console.error('Failed to update claim', error);
      }
    );
  }
}
