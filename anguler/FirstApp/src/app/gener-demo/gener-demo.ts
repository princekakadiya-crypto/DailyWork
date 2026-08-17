import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-gener-demo',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './gener-demo.html',
  styleUrls: ['./gener-demo.css'],
})
export class GenreDemoComponent {
  GenreId: number = 1;
  GenreCode: string = 'ACT';
  GenreDesc: string = 'Action Movie';

  getString(): string {
    return 'Hello Angular!';
  }

  num: number = 10;

  selectedState: string = '';

  updateGener($event: any):void {
    this.GenreDesc = $event.target.value;
  }
  updateNum():void {
    this.num = this.num *3;
  }

}
