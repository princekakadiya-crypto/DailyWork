import { Component } from '@angular/core';
import { Author } from '../model/Author';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-author-component',
  imports: [FormsModule],
  templateUrl: './add-author-component.html',
  styleUrl: './add-author-component.css',
})
export class AddAuthorComponent {
  Author:Author={authorId:0,  name:'',  country:''}

  addAuthor() {
    console.log(this.Author);
  }
}
