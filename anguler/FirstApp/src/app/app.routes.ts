import { Routes } from '@angular/router';
import { CategoryComponent } from './category-component/category-component';
import { AuthorComponent } from './author-component/author-component';
import { HomeComponent } from './home-component/home-component';
import { AddAuthorComponent } from './add-author-component/add-author-component';
import { ReviewComponent } from './review-component/review-component';
import { EditAuthorComponent } from './edit-author-component/edit-author-component';

export const routes: Routes = [
    {path:'',redirectTo:'home',pathMatch:'full'},
    {path:'home',loadComponent: () => import('./home-component/home-component').then(m => m.HomeComponent)},
    {path:'category',loadComponent: () => import('./category-component/category-component').then(m => m.CategoryComponent)},
    {path:'author',loadComponent: () => import('./author-component/author-component').then(m => m.AuthorComponent)},
    {path:'add-author',loadComponent: () => import('./add-author-component/add-author-component').then(m => m.AddAuthorComponent)},
    {path:'edit-author/:id',loadComponent: () => import('./edit-author-component/edit-author-component').then(m => m.EditAuthorComponent)},
    {path:'review',loadComponent: () => import('./review-component/review-component').then(m => m.ReviewComponent)},
    {path:'**',loadComponent: () => import('./error/error-component/error-component').then(m => m.ErrorComponent)}
];
