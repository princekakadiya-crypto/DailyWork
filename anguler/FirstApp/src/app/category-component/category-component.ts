import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api-service';
import { Category } from '../model/Category';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-category-component',
  imports: [CommonModule],
  templateUrl: './category-component.html',
  styleUrl: './category-component.css',
})
export class CategoryComponent implements OnInit {

  constructor(private service: ApiService,private cdr: ChangeDetectorRef) {  }

  categories: Category[] = [];

  ngOnInit(): void {
    this.service.getCategory().subscribe({
      next: (data: Category[]) => {
        console.log('Categories loaded:', data);
        this.categories = data;
        this.cdr.detectChanges();
      },
      error: (error) => {
        console.error('Failed to load categories:', error);
      }
    });
  }
}
