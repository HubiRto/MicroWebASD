import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BinSearchComponent} from "./components/bin-search/bin-search.component";
import {PartitionComponent} from "./components/partition/partition.component";
import {HoarePartitionComponent} from "./components/hoare-partition/hoare-partition.component";
import {MergeSortComponent} from "./components/merge-sort/merge-sort.component";

const routes: Routes = [
  {path: 'algorithm/binary-search', component: BinSearchComponent},
  {path: 'algorithm/partition', component: PartitionComponent},
  {path: 'algorithm/hoare-partition', component: HoarePartitionComponent},
  {path: 'algorithm/sort/merge-sort', component: MergeSortComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
