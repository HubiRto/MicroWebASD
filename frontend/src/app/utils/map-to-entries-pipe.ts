import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mapToEntries'
})
export class MapToEntriesPipe implements PipeTransform {
  transform(value: Map<any, any>): any[] {
    return Array.from(value.entries());
  }
}
