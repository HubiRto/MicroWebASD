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
import {HoarePartitionComponent} from './components/hoare-partition/hoare-partition.component';
import {MergeSortComponent} from "./components/merge-sort/merge-sort.component";
import {InsertionSortComponent} from './components/insertion-sort/insertion-sort.component';
import {CountingSortComponent} from "./components/counting-sort/counting-sort.component";
import {QuickSortPartitionComponent} from "./components/quick-sort-partition/quick-sort-partition.component";
import {RadixSortComponent} from "./components/radix-sort/radix-sort.component";
import {DepthFirstSearchComponent} from "./components/depth-first-search/depth-first-search.component";
import {MatIconButton} from "@angular/material/button";
import {MapToEntriesPipe} from "./utils/map-to-entries-pipe";

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    BinSearchComponent,
    PartitionComponent,
    HoarePartitionComponent,
    MergeSortComponent,
    InsertionSortComponent,
    CountingSortComponent,
    QuickSortPartitionComponent,
    RadixSortComponent,
    DepthFirstSearchComponent,
    MapToEntriesPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FaIconComponent,
    MatIconModule,
    HttpClientModule,
    MatIconButton
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
