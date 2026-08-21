import { Injectable } from '@angular/core';
import { Author } from '../model/Author';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthorService {
  constructor(private http: HttpClient) {}

  getAuthors():Observable<Author[]> {
    return this.http.get<Author[]>('http://localhost:8080/app/authors');
  }

  addAuthor(author: Author): Observable<Author> {
    return this.http.post<Author>('http://localhost:8080/app/authors', author);
  }

  getAuthorById(id: number): Observable<Author> {
    return this.http.get<Author>(`http://localhost:8080/app/authors/${id}`);
  }

  updateAuthor(id: number, author: Author): Observable<Author> {
    return this.http.put<Author>(`http://localhost:8080/app/authors/${id}`, author);
  }

}
