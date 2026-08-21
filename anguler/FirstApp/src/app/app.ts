import { Component, signal } from '@angular/core';
import { GenreDemoComponent } from './gener-demo/gener-demo';
import { DirectiveDemo } from './directive-demo/directive-demo';
import { HomeComponent } from './home-component/home-component';
import { CategoryComponent } from './category-component/category-component';
import { AuthorComponent } from './author-component/author-component';
import { AddAuthorComponent } from './add-author-component/add-author-component';
import { ReviewComponent } from './review-component/review-component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [GenreDemoComponent, DirectiveDemo, HomeComponent,CategoryComponent,AuthorComponent,AddAuthorComponent,ReviewComponent,RouterOutlet],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('FirstApp');
}
