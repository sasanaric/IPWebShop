import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { User } from 'src/app/models/user';
import { ProductService } from 'src/app/services/product.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
   user: User;
   userId = 0;
   activeProducts: Product[];
   activeProductsPage = 0;
   totalActiveProducts = 0;
   soldProducts: Product[];
   soldProductsPage = 0;
   totalSoldProducts = 0;
   page = 0;
  constructor(
    private userService: UserService,
    private productService: ProductService,
    private route: ActivatedRoute
  ){
    this.user = new User();
    this.activeProducts = [];
    this.soldProducts = [];
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      const userId = +params['id'];
      this.userId = userId;
      this.loadUser(userId);
      this.loadActiveProducts(userId);
      this.loadSoldProducts(userId);
    });
  }

  loadUser(id: number): void{
    this.userService.findById(id).subscribe(
      user => this.user = user
    )
  }
  loadActiveProducts(id:number): void{
    this.productService.getActiveProductsByUserId(this.activeProductsPage,id).subscribe(response =>{
      this.activeProducts = response.content;
      this.totalActiveProducts = response.totalElements;}
    )
  }
  loadSoldProducts(id:number): void{
    this.productService.getSoldProductsByUserId(this.soldProductsPage,id).subscribe(response =>{
      this.soldProducts = response.content;
      this.totalSoldProducts = response.totalElements;}
    )
  }
  totalPagesActive(): number {
      return Math.ceil(this.totalActiveProducts / 16);
  }
  totalPagesSold(): number {
      return Math.ceil(this.totalSoldProducts / 16);
  }
  goToPreviousPageActive(): void {
      if (this.activeProductsPage > 0) {
        this.activeProductsPage--;
        this.loadActiveProducts(this.userId);
        window.scrollTo(0,0);
      }
  }
  goToNextPageActive(): void {
      if (this.activeProductsPage < this.totalPagesActive() - 1) {
        this.activeProductsPage++;
        this.loadActiveProducts(this.userId);
        window.scrollTo(0,0);
      }
  }
  goToPreviousPageSold(): void {
      if (this.soldProductsPage > 0) {
        this.soldProductsPage--;
        this.loadSoldProducts(this.userId);
      }
  }

  goToNextPageSold(): void {
      if (this.soldProductsPage < this.totalPagesSold() - 1) {
        this.soldProductsPage++;
        this.loadSoldProducts(this.userId);
      }
  }
  goToFirstPageActive():void {
    if(this.activeProductsPage>0){
      this.activeProductsPage
      this.loadActiveProducts(this.userId);
    }
  }
  goToFirstPageSold():void {
    if(this.soldProductsPage>0){
      this.soldProductsPage
      this.loadSoldProducts(this.userId);
    }
  }
  goToLastPageActive(): void {
    if(this.activeProductsPage < this.totalPagesActive()-1){
      this.activeProductsPage = this.totalPagesActive()-1;
      this.loadActiveProducts(this.userId);
    }
  }
  goToLastPageSold(): void {
    if(this.soldProductsPage < this.totalPagesSold()-1){
      this.soldProductsPage = this.totalPagesSold()-1;
      this.loadSoldProducts(this.userId);
    }
  }



}
