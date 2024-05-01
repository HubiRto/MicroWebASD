import {PartitionState} from "./partition-state";

export interface PartitionOutput {
  result: number;
  states: PartitionState[];
}
