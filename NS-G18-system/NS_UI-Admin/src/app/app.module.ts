import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatCheckboxModule, MatAutocompleteModule, MatDatepickerModule, MatFormFieldModule, MatRadioModule, MatSelectModule, MatSlideToggleModule, MatSliderModule, MatMenuModule, MatGridListModule, MatSidenavModule, MatStepperModule, MatPaginatorModule, MatSortModule, MatTableModule, MatSnackBarModule, MatTooltipModule, MatDialogModule, MatProgressBarModule, MatProgressSpinnerModule, MatIconModule, MatChipsModule, MatButtonToggleModule, MatExpansionModule, MatTabsModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ComponentNsComponent } from './component/component-ns/component-ns.component';
import { ComponentNsUiShowComponent } from './component-ns-ui-show/component-ns-ui-show.component';
import { RelatedInformationService } from './service/relatedInformation-service/related-information.service';
import { LoginComponent } from './component/login/login.component';
import { JobpageComponent } from './component/jobpage/jobpage.component';
const appRoutes: Routes = [
  { path: '',   redirectTo: '/Login',    pathMatch: 'full'  },
  { path: 'Login', component: LoginComponent},
  { path: 'ComponentNs', component: ComponentNsComponent },
  { path: 'ComponentNsUiShow', component: ComponentNsUiShowComponent },
  { path: 'Jobpage', component: JobpageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ComponentNsComponent,
    ComponentNsUiShowComponent,
    LoginComponent,
    JobpageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    MatCheckboxModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [RelatedInformationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
