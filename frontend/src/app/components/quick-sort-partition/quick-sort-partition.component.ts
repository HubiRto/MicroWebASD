import {Component} from '@angular/core';
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {HttpClient} from "@angular/common/http";
import {QuickSortPartitionOutput} from "../../interface/quick-sort-partition-output";

@Component({
  selector: 'app-quick-sort-partition',
  templateUrl: './quick-sort-partition.component.html'
})
export class QuickSortPartitionComponent extends AlgorithmComponentComponent<QuickSortPartitionOutput>{
  arrayInput: string = '';
  numberInput: number = 0;

  constructor(http: HttpClient) {
    super(http, 'sort/quick-sort-partition');
  }

  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim()))
    };
  }
}
