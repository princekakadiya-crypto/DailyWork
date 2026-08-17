import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moveTypePipe',
})
export class MoveTypePipePipe implements PipeTransform {
  transform(value: number, ...args: number[]): string {
    if(value>3){
      return value + ' - Hit Movie - Disc '+ args[0]*10;
    }
    else if(value==3){
      return value + ' - Average Movie - Disc '+ args[0]*10;
    }
    else{
      return value + ' - Poor Movie - Disc '+ args[0]*10;
    }
  }
}
