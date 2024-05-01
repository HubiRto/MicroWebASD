import {CalculateResponse} from "../../model/calculate-response";
import {HttpClient} from "@angular/common/http";
import {AlgorithmInput} from "../../interface/algorithm-input";

export abstract class AlgorithmComponentComponent<T> {
  baseUrl: string = 'http://localhost:8787/api/v1/algorithm/';
  result: CalculateResponse<T> | null = null;

  protected constructor(protected http: HttpClient, private pathUrl: string) {
  }

  abstract createInput(): AlgorithmInput;

  processData(): void {
    const input = this.createInput();
    if (this.isValidInput(input)) {
      this.http.post<CalculateResponse<T>>(this.baseUrl + this.pathUrl, input).subscribe({
        next: (response: CalculateResponse<T>) => {
          this.result = response;
        },
        error: (error) => {
          console.error('Error:', error);
        }
      });
    }
  }

  isValidInput(input: AlgorithmInput): boolean {
    return Object
      .values(input)
      .every(param => param !== undefined && param !== null && param.toString().trim() !== '');
  }
}
