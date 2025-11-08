import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private apiUrl = 'http://localhost:8080/api/claims';

  constructor(private http: HttpClient) {}

  addClaim(claimData: any) {
    return this.http.post<number>(`${this.apiUrl}/addClaim`, claimData);
  }

  updateClaim(claimId: number, updatedClaim: any) {
    return this.http.put<any>(`${this.apiUrl}/${claimId}`, updatedClaim);
  }

  getClaimDetails(claimId: number) {
    return this.http.get<any>(`${this.apiUrl}/ok/${claimId}`);
  }
}
