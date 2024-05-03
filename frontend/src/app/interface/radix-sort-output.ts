export interface RadixSortOutput {
  steps: (number[])[];
  maxQueueLength: number;
  firstOperationCount: number;
  outOperationCount: number;
  inOperationCount: number;
}
