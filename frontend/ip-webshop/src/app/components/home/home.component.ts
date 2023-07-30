import { Component } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  products: Product[];
  constructor(private productService: ProductService){
    this.products = [];
  }

  totalProducts: number = 0;
  filters = {
    page: 0,
    size: 16,
    direction: 'desc',
    sortBy: 'id'
  };

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts(this.filters).subscribe(response => {
      this.products = response.content; // assuming response is a Page object with a 'content' property
      this.totalProducts = response.totalElements; // assuming response has a 'totalElements' property
    });
  }

  totalPages(): number {
    return Math.ceil(this.totalProducts / this.filters.size);
  }

  goToPreviousPage(): void {
    if (this.filters.page > 0) {
      this.filters.page--;
      this.loadProducts();
    }
  }

  goToNextPage(): void {
    if (this.filters.page < this.totalPages() - 1) {
      this.filters.page++;
      this.loadProducts();
    }
  }
}
