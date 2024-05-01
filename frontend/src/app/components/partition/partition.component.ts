import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PartitionOutput} from "../../model/partition-output";
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {AlgorithmInput} from "../../interface/algorithm-input";

@Component({
  selector: 'app-partition',
  templateUrl: './partition.component.html'
})
export class PartitionComponent extends AlgorithmComponentComponent<PartitionOutput> {
  arrayInput: string = '';

  constructor(http: HttpClient) {
    super(http, 'partition')
  }


  createInput(): AlgorithmInput {
    return {
      arr: this.arrayInput.split(',').map(s => Number(s.trim()))
    }
  }
}
