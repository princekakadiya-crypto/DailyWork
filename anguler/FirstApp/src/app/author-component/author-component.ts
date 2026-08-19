import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { AuthorService } from '../service/author-service';
import { Author } from '../model/Author';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-author-component',
  imports: [CommonModule],
  templateUrl: './author-component.html',
  styleUrl: './author-component.css',
})
export class AuthorComponent implements OnInit {
  constructor(private service: AuthorService,private cdr: ChangeDetectorRef) {  }

  Authors: Author[] = [];

  ngOnInit(): void {
      this.service.getAuthors().subscribe({
        next: (data: Author[]) => {
          console.log('Authors loaded:', data);
          this.Authors = data;
          this.cdr.detectChanges();
        },
        error: (error) => {
          console.error('Failed to load authors:', error);
        }
      });
    }

}
