import { Component , OnInit} from '@angular/core';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit{
  categories: Category[];
  
  constructor(private categoryService: CategoryService){
    this.categories = [];
  }

  ngOnInit(): void {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    })
  }

}
