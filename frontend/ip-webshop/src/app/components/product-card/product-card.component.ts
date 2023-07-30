import { Component, Input, OnInit } from '@angular/core';
import { Photo } from 'src/app/models/photo';
import { Product } from 'src/app/models/product';
import { PhotoService } from 'src/app/services/photo.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input() productId!: number;
  product: Product;
  productPhoto!: Photo;

  constructor(private productService: ProductService, private photoService: PhotoService) { 
    this.product = new Product();
    this.productPhoto = new Photo();
  }
  ngOnInit(): void {
    this.photoService.getFirstPhotoByProductId(this.productId).subscribe(
      photo => {
        this.productPhoto = photo;
      })
    this.productService.getProductById(this.productId).subscribe(
      product => {
        this.product = product;
      });
  }

}