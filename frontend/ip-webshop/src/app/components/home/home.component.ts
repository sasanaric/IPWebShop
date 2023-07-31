import { Component } from '@angular/core';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  products: Product[];
  categories: Category[];
  states: string[];
  selectedState: string | undefined;
  selectedCategory: Category | undefined;
  priceFrom: number | undefined;
  priceTo: number | undefined;
  showRefresh = false;
  constructor(
    private productService: ProductService,
    private categoryService: CategoryService
    ){
    this.products = [];
    this.categories = [];
    this.states = ["Novo","Polovno"]
    this.selectedCategory = undefined;
    this.selectedState = undefined;
  }

  totalProducts: number = 0;
  filters = {
    page: 0,
    size: 16,
    direction: null as string | null,
    sortBy: null as string | null,
    categoryName: null as string | null,
    state: null as string | null,
    priceFrom: null as number | null,
    priceTo: null as number | null,
    search: null as string | null
  };
  sortOptions = [
    {name: 'Najnovije', value: {sortBy: 'id', direction: 'desc'}},
    {name: 'Najstarije', value: {sortBy: 'id', direction: 'asc'}},
    {name: 'Najjeftinije', value: {sortBy: 'price', direction: 'asc'}},
    {name: 'Najskuplje', value: {sortBy: 'price', direction: 'desc'}},
  ];

  ngOnInit(): void {
    this.loadProducts();
    this.loadCategories();
  }
  priceChanged() {
    this.showRefresh = true;
  }
  loadProducts(): void {
    this.productService.getProducts(this.filters).subscribe(response => {
      this.products = response.content;
      this.totalProducts = response.totalElements;
      this.filters.page=0; 
    });
  }
  loadCategories(): void {
    this.categoryService.findAll().subscribe(response =>{
      this.categories = response;
      console.log(this.categories);
    })
  }
  updateCategory() {
    this.filters.categoryName = this.selectedCategory ? this.selectedCategory.name : null;
    this.loadProducts(); // Replace this with your method for fetching products
  }
  clearSelectedCategory() {
    this.selectedCategory = undefined;
  }
  updateState() {
    this.filters.state = this.selectedState ? this.selectedState : null;
    this.loadProducts(); // Replace this with your method for fetching products
  }
  updatePrice(){
    this.filters.priceFrom = this.priceFrom ? this.priceFrom : null;
    this.filters.priceTo = this.priceTo ? this.priceTo : null;
    this.showRefresh = false;
    this.loadProducts();
  }
  clearSelectedState() {
    this.selectedState = undefined;
  }
  selectedSortOption: { name: string, value: { sortBy: string, direction: string } } | null = null;

  updateSort() {
    if (this.selectedSortOption) {
      this.filters.sortBy = this.selectedSortOption.value.sortBy;
      this.filters.direction = this.selectedSortOption.value.direction;
    } else {
      this.filters.sortBy = null;
      this.filters.direction = null;
    }
    this.loadProducts();
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
  goToFirstPage():void {
    if(this.filters.page>0){
      this.filters.page=0;
      this.loadProducts();
    }
  }
  goToLastPage(): void {
    if(this.filters.page < this.totalPages()-1){
      this.filters.page = this.totalPages()-1;
      this.loadProducts();
    }
  }
}
