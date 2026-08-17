import { CommonModule} from '@angular/common';
import { Component } from '@angular/core';
import { Genre } from '../model/Genre';
import { Movie } from '../model/Movie';
import { HighlightDirective } from '../directive/highlight.directive';
import { MoveTypePipePipe } from '../custome/pipe/move-type-pipe-pipe';

@Component({
  selector: 'app-directive-demo',
  standalone: true,
  imports: [CommonModule, HighlightDirective, MoveTypePipePipe],
  templateUrl: './directive-demo.html',
  styleUrls: ['./directive-demo.css'],
})  
export class DirectiveDemo {
  toDisplay: boolean = false;
  num: number = 10;
  lstNum: number[] = [10, 20, 30, 40, 50];

  toggleDisplay(): void {
    this.toDisplay = !this.toDisplay;
  }
  
  //create an Array of the Genre Class
  
  genres: Genre[] = [
    {genreId:1, genreCode: 'ACT', genreDesc: 'Action Movies'},
    {genreId:2, genreCode: 'AUTO', genreDesc: 'Autobiographical Movies'},
    {genreId:3, genreCode: 'FICT', genreDesc: 'Fiction Movies'},
    {genreId:4, genreCode: 'COM', genreDesc: 'Comedy Movies'},
  ];

  movies: Movie[] = [
    { movieId: 101, movieTitle: 'Sky Strike', movieRating: 4.2, releaseDate: new Date('2023-01-12'), genreId: 1 },
    { movieId: 102, movieTitle: 'Life Notes', movieRating: 3.25258, releaseDate: new Date('2022-07-05'), genreId: 2 },
    { movieId: 103, movieTitle: 'Future Realm', movieRating: 4.5, releaseDate: new Date('2024-03-20'), genreId: 3 },
    { movieId: 104, movieTitle: 'Laugh Out Loud', movieRating: 4.0, releaseDate: new Date('2021-11-01'), genreId: 4 }
  ];

  checkOddEven(num: number): string {
    return num % 2 === 0 ? 'bold' : 'normal';
  }

  getGenreCode(genreId: number): string {
    const genre = this.genres.find((item) => item.genreId === genreId);
    return genre ? genre.genreCode : 'NA';
  }

}
