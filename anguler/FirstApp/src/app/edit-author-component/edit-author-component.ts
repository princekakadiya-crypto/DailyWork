import { Component, inject } from '@angular/core';
import { Author } from '../model/Author';
import { Observable } from 'rxjs';
import { AuthorService } from '../service/author-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-author-component',
  imports: [FormsModule],
  templateUrl: './edit-author-component.html',
  styleUrl: './edit-author-component.css',
})
export class EditAuthorComponent {
   Author:Author={authorId:0,  name:'',  country:''}
  
   service=inject(AuthorService);

  result$!: Observable<Author>;

  editAuthor() {
    console.log(this.Author);
    
  }
}
