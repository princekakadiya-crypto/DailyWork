import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { ApiService } from '../service/api-service';
import { Category } from '../model/Category';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-category-component',
  imports: [CommonModule],
  templateUrl: './category-component.html',
  styleUrl: './category-component.css',
})
export class CategoryComponent implements OnInit {

  categories!: Category[];
  categories$!: Observable<Category[]>;

  service=inject(ApiService);

  ngOnInit(): void {
    this.categories$ = this.service.getCategory();
  }
}
