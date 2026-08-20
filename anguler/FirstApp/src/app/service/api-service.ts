import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/Category';
import { ReviewRequest } from '../model/ReviewRequest';
import { Book } from '../model/Book';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}

  getCategory():Observable<Category[]> {
    return this.http.get<Category[]>('http://localhost:8080/app/categories');
  }

  getBooks(): Observable<Book[]> {
  return this.http.get<Book[]>(
    'http://localhost:8080/app/books/all'
  );
}

addReview(review: ReviewRequest): Observable<any> {
  return this.http.post(
    'http://localhost:8080/app/reviews',
    review
  );
}

}
