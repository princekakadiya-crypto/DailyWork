import { Component, inject } from '@angular/core';
import { Author } from '../model/Author';
import { FormsModule } from '@angular/forms';
import { AuthorService } from '../service/author-service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-author-component',
  imports: [FormsModule],
  templateUrl: './add-author-component.html',
  styleUrl: './add-author-component.css',
})
export class AddAuthorComponent {
  Author:Author={authorId:0,  name:'',  country:''}


  service=inject(AuthorService);

  result$!: Observable<Author>;

  addAuthor() {
    console.log(this.Author);
    
    this.result$ = this.service.addAuthor(this.Author);

    this.result$.subscribe({
      next: (author) => {
        console.log('Author added:', author);
      },
      error: (error) => {
        console.error('Error adding author:', error);
      }
    });
  }
}
