import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Movie } from '../../model/Movie';

@Component({
  selector: 'app-movie-detail',
  standalone: true,
  imports: [],
  templateUrl: './movie-detail.html',
  styleUrl: './movie-detail.css',
})
export class MovieDetail {
  @Input() dataFromparent: string = '';
  @Input() movieFromParent: Movie = {
    movieId: 0,
    movieTitle: '',
    movieRating: 0,
    releaseDate: new Date(),
    genreId: 0
  };
  @Output() dataToParent: EventEmitter<string> = new EventEmitter<string>();

  sendToParent(): void {
    this.dataToParent.emit('Hello from Movie Detail Component');
  }
}
