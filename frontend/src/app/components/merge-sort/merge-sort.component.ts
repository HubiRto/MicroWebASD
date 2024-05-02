import {Component} from '@angular/core';
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {HttpClient} from "@angular/common/http";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {MergeSortOutput} from "../../interface/merge-sort-output";

@Component({
  selector: 'app-hoare-partition',
  templateUrl: './merge-sort.component.html'
})
export class MergeSortComponent extends AlgorithmComponentComponent<MergeSortOutput>{
  arrayInput: string = '';

  constructor(http: HttpClient) {
    super(http, 'sort/merge-sort');
  }

  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim())),
    };
  }
}
