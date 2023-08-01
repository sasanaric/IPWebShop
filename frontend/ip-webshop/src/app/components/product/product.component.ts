import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/models/product';
import { Photo } from 'src/app/models/photo';
import { PhotoService } from 'src/app/services/photo.service';
import { ProductAttribute } from 'src/app/models/product-attribute';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product: Product;
  user: User;
  productAttributes: ProductAttribute[];
  productPhotos: Photo[];
  currentPhotoIndex = 0;
  constructor(
    private productService: ProductService,
    private photoService: PhotoService,
    private route: ActivatedRoute
  ) { 
    this.product = new Product();
    this.user = new User();
    this.productPhotos = [];
    this.productAttributes = [];
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const productId = +params['id'];
      this.getProduct(productId);
      this.getProductAttributes(productId);
      this.getProductPhotos(productId);
    });
  }

  getProduct(productId: number) {
    this.productService.getProductById(productId).subscribe(
      (product: Product) => {
        this.product = product;
      }
    );
  }
  getProductAttributes(productId: number){
    this.productService.getProductAttributesById(productId).subscribe(
      (attributes: ProductAttribute[]) => {
        this.productAttributes = attributes;
      }
    )
  }
  getProductPhotos(productId: number){
    this.photoService.getPhotosByProductId(productId).subscribe(
      (photos: Photo[]) => {
        this.productPhotos = photos;
      }
    )
  }
  nextPhoto(): void {
    if (this.currentPhotoIndex < this.productPhotos.length - 1) {
      this.currentPhotoIndex++;
    }
  }

  previousPhoto(): void {
    if (this.currentPhotoIndex > 0) {
      this.currentPhotoIndex--;
    }
  }
}
