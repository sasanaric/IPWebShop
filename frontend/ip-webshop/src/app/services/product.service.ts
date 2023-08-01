import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { ProductAttribute } from '../models/product-attribute';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl: string;
  private attributesUrl: string;
  constructor(private http: HttpClient) {
      this.productsUrl='http://localhost:8080/products';
      this.attributesUrl='http://localhost:8080/product-attribute/product';
  }
  public getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.productsUrl}/${id}`);
  }
  public getProductAttributesById(id:number): Observable<ProductAttribute[]>{
    return this.http.get<ProductAttribute[]>(`${this.attributesUrl}/${id}`);
  }
  public getActiveProductsByUserId(page:number, id: number): Observable<any> {
    return this.http.get<any>(`${this.productsUrl}/user/${id}/active?page=${page}`);
  }
  public getSoldProductsByUserId(page: number, id: number): Observable<any> {
    return this.http.get<any>(`${this.productsUrl}/user/${id}/sold?page=${page}`);
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
