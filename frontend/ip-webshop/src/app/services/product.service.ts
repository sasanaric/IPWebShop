import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl: string;
  constructor(private http: HttpClient) {
      this.productsUrl='http://localhost:8080/products';
  }
  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.productsUrl}/${id}`);
  }
  public findAll(): Observable<Product[]>{
    return this.http.get<Product[]>(this.productsUrl);
  }
  public getProducts(options: {  
    page: number | null, 
    size: number | null,
    priceFrom: number | null, 
    priceTo: number | null, 
    categoryName: string | null, 
    state: string | null, 
    direction: string | null, 
    sortBy: string | null, 
    search: string | null 
}): Observable<any> {
  
    let queryString = `${this.productsUrl}/filter?page=${options.page || 0}&size=${options.size || 16}`;
    if (options.direction) {
      queryString += `&direction=${options.direction}`;
    }
    if (options.sortBy) {
      queryString += `&sortBy=${options.sortBy}`;
    }
    if (options.priceFrom) {
      queryString += `&priceFrom=${options.priceFrom}`;
    }
    if (options.priceTo) {
      queryString += `&priceTo=${options.priceTo}`;
    }
    if (options.categoryName) {
      queryString += `&categoryName=${options.categoryName}`;
    }
    if (options.state) {
      queryString += `&state=${options.state}`;
    }
    if (options.search) {
      queryString += `&search=${options.search}`;
    }
    console.log(queryString);
    return this.http.get<any>(queryString);
}

  
  
}
