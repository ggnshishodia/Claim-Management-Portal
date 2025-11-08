import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DataService } from './data.service';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CreateClaimComponent } from './components/create-claim/create-claim.component';
import { UpdateClaimComponent } from './components/update-claim/update-claim.component';

const routes: Routes = [
  { path: 'create-claim', component: CreateClaimComponent },
  { path: 'update-claim', component: UpdateClaimComponent },
  { path: '', redirectTo: 'create-claim', pathMatch: 'full' },
];

@NgModule({
  declarations: [AppComponent, CreateClaimComponent, UpdateClaimComponent],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [DataService],
  bootstrap: [AppComponent],
})
export class AppModule {}