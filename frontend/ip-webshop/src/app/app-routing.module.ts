import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CategoryFormComponent } from './components/category-form/category-form.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { AuthGuard } from './auth/auth.guard';
import { UserInfoComponent } from './components/user-info/user-info.component';

const routes: Routes = [
  { 
    path: 'user-info', component: UserInfoComponent, canActivate: [AuthGuard] 
  },
  { 
    path: '', pathMatch: 'full', redirectTo: 'home'
  },
  { 
    path: 'home', component: HomeComponent
  },
  { 
    path: 'login', component: LoginComponent
  },
  {
    path: 'categories', component: CategoryListComponent
  },
  {
    path: 'addcategory',component: CategoryFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
