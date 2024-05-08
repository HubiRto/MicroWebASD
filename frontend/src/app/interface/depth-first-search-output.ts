export interface DepthFirstSearchOutput {
  paths: { [key: string]: number[] };
  pushOperationCount: number;
  popOperationCount: number;
  externalCount: number;
  internalCount: number;
  maxDepth: number;
  maxStackSize: number;
  traverse: number[];
}
