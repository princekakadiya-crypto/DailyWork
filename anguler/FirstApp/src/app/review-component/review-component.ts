import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule,Validators } from '@angular/forms';
import { ReviewRequest } from '../model/ReviewRequest';
import { Book } from '../model/Book';
import { ApiService } from '../service/api-service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-review-component',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './review-component.html',
  styleUrl: './review-component.css',
})
export class ReviewComponent {
  reviewForm!: FormGroup;

  books$!: Observable<Book[]>;

  constructor(
    private apiService: ApiService
  ) {}

  ngOnInit(): void {

    this.reviewForm = new FormGroup({

      bookId: new FormControl(null, [
        Validators.required
      ]),

      rating: new FormControl(null, [
        Validators.required,
        Validators.min(1),
        Validators.max(5)
      ]),

      comment: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(500)
      ])

    });

    this.books$ = this.apiService.getBooks();
  }


  addReview(): void {

    const review: ReviewRequest = {
      bookId: this.reviewForm.value.bookId,
      rating: this.reviewForm.value.rating,
      comment: this.reviewForm.value.comment,
      userId: 16
    };

    console.log(review);

    this.apiService.addReview(review).subscribe({

      next: (response) => {
        console.log('Review added successfully:', response);

        this.reviewForm.reset();
      },

      error: (error) => {
        console.error('Error adding review:', error);
      }

    });
  }

  get bookId(): FormControl {
    return this.reviewForm.get('bookId') as FormControl;
  }

  get rating(): FormControl {
    return this.reviewForm.get('rating') as FormControl;
  }

  get comment(): FormControl {
    return this.reviewForm.get('comment') as FormControl;
  }
}

