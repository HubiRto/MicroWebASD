export interface CalculateResponse<T> {
  timestamp: Date;
  calculateTimeMilSec: number;
  data: { result?: T }
}
