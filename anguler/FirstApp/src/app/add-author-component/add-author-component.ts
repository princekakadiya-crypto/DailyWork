import { Component, inject } from '@angular/core';
import { Author } from '../model/Author';
import { FormsModule } from '@angular/forms';
import { AuthorService } from '../service/author-service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-author-component',
  imports: [FormsModule,CommonModule],
  templateUrl: './add-author-component.html',
  styleUrl: './add-author-component.css',
})
export class AddAuthorComponent {
  Author:Author={authorId:0,  name:'',  country:''}


  service=inject(AuthorService);
  router=inject(Router);

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

    this.router.navigate(['/author']);

  }
}
