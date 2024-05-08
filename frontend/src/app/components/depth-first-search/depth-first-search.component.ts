import {Component} from '@angular/core';
import {AlgorithmComponentComponent} from "../algorithm-component/algorithm-component.component";
import {AlgorithmInput} from "../../interface/algorithm-input";
import {HttpClient} from "@angular/common/http";
import {DepthFirstSearchOutput} from "../../interface/depth-first-search-output";

@Component({
  selector: 'app-bin-search',
  templateUrl: './depth-first-search.component.html',
  styleUrl: './depth-first-search.component.css'
})
export class DepthFirstSearchComponent extends AlgorithmComponentComponent<DepthFirstSearchOutput> {
  graph: string[] = [''];
  startIndex: number = 0;

  objectKeys(obj: any = {}): string[] {
    return Object.keys(obj || {});
  }

  constructor(http: HttpClient) {
    super(http, 'first-search/depth-first-search');
  }

  createInput(): AlgorithmInput {
    return {
      graph: this.graph.map(row => row.split(',').map(Number)),
      x: Number(this.startIndex)
    };
  }

  addNewRow(): void {
    this.graph.push('');
  }

  getVerticesPath(key: string): string {
    if (this.result && this.result.data && this.result.data.result && this.result.data.result.paths && this.result.data.result.paths[key]) {
      return this.result.data.result.paths[key].join(', ');
    }
    return 'Brak danych';
  }
}
