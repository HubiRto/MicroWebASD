import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './components/app/app.component';
import {SidebarComponent} from './components/sidebar/sidebar.component';
import {FormsModule} from "@angular/forms";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {MatIconModule} from "@angular/material/icon";
import {BinSearchComponent} from './components/bin-search/bin-search.component';
import {HttpClientModule} from "@angular/common/http";
import {PartitionComponent} from './components/partition/partition.component';
import { AlgorithmComponentComponent } from './components/algorithm-component/algorithm-component.component';
import { HoarePartitionComponent } from './components/hoare-partition/hoare-partition.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    BinSearchComponent,
    PartitionComponent,
    HoarePartitionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FaIconComponent,
    MatIconModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
