import { Component, inject, Input, OnInit } from '@angular/core';
import { Author } from '../model/Author';
import { Observable } from 'rxjs';
import { AuthorService } from '../service/author-service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-author-component',
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './edit-author-component.html',
  styleUrl: './edit-author-component.css',
})
export class EditAuthorComponent implements OnInit {

  @Input() id!: number;

  editAuthorForm!:FormGroup;
  Author$!:Observable<Author>;
  Author!:Author;
  service=inject(AuthorService);
  router=inject(Router);
  
  ngOnInit(): void {
    this.Author$ = this.service.getAuthorById(this.id);
    this.Author$.subscribe(
      data=>{
        this.Author = data;
        this.editAuthorForm = new FormGroup({
          id: new FormControl(this.Author.authorId),
          name: new FormControl(this.Author.name,[Validators.required,Validators.minLength(2),Validators.maxLength(100)]),
          country: new FormControl(this.Author.country,[Validators.required,Validators.maxLength(100)])
        });
      },
      error=>{
        console.error('Error fetching author:', error);
      }
    );
  }

  editAuthor() {
    const id=this.editAuthorForm.value.id;
    this.service.updateAuthor(id, this.editAuthorForm.value).subscribe({
      next: (author) => {
        console.log('Author updated:', author);
      },
      error: (error) => {
        console.error('Error updating author:', error);
      }
    });
    this.router.navigate(['/author']);
  }

  get name() {
    return this.editAuthorForm.get('name');
  }

  get country() {
    return this.editAuthorForm.get('country');
  }

}
