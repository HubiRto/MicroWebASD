import {MergeSortStep} from "./merge-sort-step";

export interface MergeSortOutput {
  recursiveCallCount: number;
  mergeCount: number;
  maxDepth: number;
  steps: MergeSortStep[];
  sortedArray: number[];
  originalArray: number[];
}
