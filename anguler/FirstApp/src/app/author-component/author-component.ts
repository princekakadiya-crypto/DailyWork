import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { AuthorService } from '../service/author-service';
import { Author } from '../model/Author';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-author-component',
  imports: [CommonModule,RouterLink],
  templateUrl: './author-component.html',
  styleUrl: './author-component.css',
})
export class AuthorComponent implements OnInit {
  //constructor(private service: AuthorService,private cdr: ChangeDetectorRef) {  }

  service=inject(AuthorService);

  Authors!: Author[];

  Authors$!: Observable<Author[]>;

  ngOnInit(): void {
      // this.service.getAuthors().subscribe({
      //   next: (data: Author[]) => {
      //     console.log('Authors loaded:', data);
      //     this.Authors = data;
      //     this.cdr.detectChanges();
      //   },
      //   error: (error) => {
      //     console.error('Failed to load authors:', error);
      //   }
      // });

      this.Authors$ = this.service.getAuthors();

    }

}
