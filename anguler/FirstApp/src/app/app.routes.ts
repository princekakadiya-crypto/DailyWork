import { Routes } from '@angular/router';
import { CategoryComponent } from './category-component/category-component';
import { AuthorComponent } from './author-component/author-component';
import { HomeComponent } from './home-component/home-component';
import { AddAuthorComponent } from './add-author-component/add-author-component';
import { ReviewComponent } from './review-component/review-component';
import { EditAuthorComponent } from './edit-author-component/edit-author-component';

export const routes: Routes = [
    {path:'',redirectTo:'home',pathMatch:'full'},
    {path:'home',component:HomeComponent},
    {path:'category',component:CategoryComponent},
    {path:'author',component:AuthorComponent},
    {path:'add-author',component:AddAuthorComponent},
    {path:'edit-author',component:EditAuthorComponent},
    {path:'review',component:ReviewComponent}
];
