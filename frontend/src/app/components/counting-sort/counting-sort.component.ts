import {Component} from '@angular/core';
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {HttpClient} from "@angular/common/http";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {CountingSortOutput} from "../../interface/counting-sort-output";

@Component({
  selector: 'app-counting-sort',
  templateUrl: './counting-sort.component.html'
})
export class CountingSortComponent extends AlgorithmComponentComponent<CountingSortOutput> {
  arrayInput: string = '';

  constructor(http: HttpClient) {
    super(http, 'sort/counting-sort');
  }

  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim())),
    };
  }
}
