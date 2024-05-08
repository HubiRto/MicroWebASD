import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BinSearchComponent} from "./components/bin-search/bin-search.component";
import {PartitionComponent} from "./components/partition/partition.component";
import {HoarePartitionComponent} from "./components/hoare-partition/hoare-partition.component";
import {MergeSortComponent} from "./components/merge-sort/merge-sort.component";
import {InsertionSortComponent} from "./components/insertion-sort/insertion-sort.component";
import {CountingSortComponent} from "./components/counting-sort/counting-sort.component";
import {QuickSortPartitionComponent} from "./components/quick-sort-partition/quick-sort-partition.component";
import {RadixSortComponent} from "./components/radix-sort/radix-sort.component";
import {DepthFirstSearchComponent} from "./components/depth-first-search/depth-first-search.component";

const routes: Routes = [
  {path: 'algorithm/binary-search', component: BinSearchComponent},
  {path: 'algorithm/partition', component: PartitionComponent},
  {path: 'algorithm/hoare-partition', component: HoarePartitionComponent},
  {path: 'algorithm/sort/merge-sort', component: MergeSortComponent},
  {path: 'algorithm/sort/insertion-sort', component: InsertionSortComponent},
  {path: 'algorithm/sort/counting-sort', component: CountingSortComponent},
  {path: 'algorithm/sort/quick-sort-partition', component: QuickSortPartitionComponent},
  {path: 'algorithm/sort/radix-sort', component: RadixSortComponent},
  {path: 'algorithm/first-search/depth-first-search', component: DepthFirstSearchComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
