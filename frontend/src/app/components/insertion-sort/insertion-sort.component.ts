import {Component} from '@angular/core';
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {HttpClient} from "@angular/common/http";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {InsertionSortOutput} from "../../interface/insertion-sort-output";

@Component({
  selector: 'app-insertion-sort',
  templateUrl: './insertion-sort.component.html'
})
export class InsertionSortComponent extends AlgorithmComponentComponent<InsertionSortOutput>{
  arrayInput: string = '';

  constructor(http: HttpClient) {
    super(http, 'sort/insertion-sort');
  }

  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim())),
    };
  }
}
