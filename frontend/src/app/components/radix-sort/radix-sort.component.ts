import {Component} from '@angular/core';
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {HttpClient} from "@angular/common/http";
import {RadixSortOutput} from "../../interface/radix-sort-output";

@Component({
  selector: 'app-bin-search',
  templateUrl: './radix-sort.component.html'
})
export class RadixSortComponent extends AlgorithmComponentComponent<RadixSortOutput> {
  arrayInput: string = '';
  numberInput: number = 0;

  constructor(http: HttpClient) {
    super(http, 'sort/radix-sort');
  }

  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim())),
      d: Number(this.numberInput)
    };
  }
}
