import {Component, ElementRef} from '@angular/core';
import {BinSearchOutput} from "../../model/bin-search-output";
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-bin-search',
  templateUrl: './bin-search.component.html'
})
export class BinSearchComponent extends AlgorithmComponentComponent<BinSearchOutput> {
  arrayInput: string = '';
  numberInput: number = 0;

  constructor(http: HttpClient, private el: ElementRef) {
    super(http, 'binary-search');
  }

  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim())),
      x: Number(this.numberInput)
    };
  }
}
