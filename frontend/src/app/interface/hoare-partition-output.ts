import {HoarePartitionStep} from "./hoare-partition-step";

export interface HoarePartitionOutput {
  result: number;
  depth: number;
  steps: HoarePartitionStep[];
  partitionCount: number;
}
