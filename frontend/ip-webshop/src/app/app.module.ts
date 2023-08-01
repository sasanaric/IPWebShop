import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CategoryFormComponent } from './components/category-form/category-form.component';
import { CategoryService } from './services/category.service';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { UserInfoComponent } from './components/user-info/user-info.component';
import { ProductCardComponent } from './components/product-card/product-card.component';
import { UserInterfaceModule } from './modules/user-interface/user-interface.module';
import { ProductComponent } from './components/product/product.component';
import { ProductService } from './services/product.service';
import { PhotoService } from './services/photo.service';
import { UserComponent } from './components/user/user.component';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    CategoryListComponent,
    CategoryFormComponent,
    HomeComponent,
    LoginComponent,
    UserInfoComponent,
    ProductCardComponent,
    ProductComponent,
    ProductComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NoopAnimationsModule,
    UserInterfaceModule
  ],
  providers: [
    CategoryService,ProductService,
    PhotoService,UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
