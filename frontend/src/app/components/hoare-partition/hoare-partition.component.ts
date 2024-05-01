import { Component } from '@angular/core';
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {BinSearchOutput} from "../../model/bin-search-output";
import {HttpClient} from "@angular/common/http";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {HoarePartitionOutput} from "../../interface/hoare-partition-output";

@Component({
  selector: 'app-hoare-partition',
  templateUrl: './hoare-partition.component.html'
})
export class HoarePartitionComponent extends AlgorithmComponentComponent<HoarePartitionOutput>{
  arrayInput: string = '';
  numberInput: number = 0;

  constructor(http: HttpClient) {
    super(http, 'hoare-partition');
  }

  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim())),
      k: Number(this.numberInput)
    };
  }
}
