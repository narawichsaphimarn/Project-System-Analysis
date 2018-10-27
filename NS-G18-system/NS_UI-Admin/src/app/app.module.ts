import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatCheckboxModule, MatAutocompleteModule, MatDatepickerModule, MatFormFieldModule, MatRadioModule, MatSelectModule, MatSlideToggleModule, MatSliderModule, MatMenuModule, MatGridListModule, MatSidenavModule, MatStepperModule, MatPaginatorModule, MatSortModule, MatTableModule, MatSnackBarModule, MatTooltipModule, MatDialogModule, MatProgressBarModule, MatProgressSpinnerModule, MatIconModule, MatChipsModule, MatButtonToggleModule, MatExpansionModule, MatTabsModule,MatNativeDateModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ComponentNsComponent } from './component/component-ns/component-ns.component';
import { ComponentNsUiShowComponent } from './component-ns-ui-show/component-ns-ui-show.component';
import { RelatedInformationService } from './service/relatedInformation-service/related-information.service';
import { LoginComponent } from './component/login/login.component';
import { JobpageComponent } from './component/jobpage/jobpage.component';
import { AccountService } from './service/account.service';
import { AccountComponent } from "./component/account/account.component";
import { TableComponent } from "./component/table/table.component";

const appRoutes: Routes = [
  { path: '',   redirectTo: '/Login',    pathMatch: 'full'  },
  { path: 'Login', component: LoginComponent},
  { path: 'ComponentNs', component: ComponentNsComponent },
  { path: 'ComponentNsUiShow', component: ComponentNsUiShowComponent },
  { path: 'Jobpage', component: JobpageComponent},
  { path: 'table' , component: TableComponent},
  { path: 'account' , component: AccountComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ComponentNsComponent,
    ComponentNsUiShowComponent,
    LoginComponent,
    JobpageComponent,
    AccountComponent,
    TableComponent
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
    MatNativeDateModule,
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
  providers: [RelatedInformationService,AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
