import { Component, signal } from '@angular/core';
import { GenreDemoComponent } from './gener-demo/gener-demo';
import { DirectiveDemo } from './directive-demo/directive-demo';
import { HomeComponent } from './home-component/home-component';
import { CategoryComponent } from './category-component/category-component';
import { AuthorComponent } from './author-component/author-component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [GenreDemoComponent, DirectiveDemo, HomeComponent,CategoryComponent,AuthorComponent],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('FirstApp');
}
