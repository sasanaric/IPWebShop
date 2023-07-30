import { Component } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent {
  category: Category;
  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private categoryService: CategoryService){
          this.category = new Category();
  }

  onSubmit(){
    this.categoryService.post(this.category).subscribe(result => this.gotoCategoryList());
  }

  gotoCategoryList(){
    this.router.navigate(['/categories']);
  }
}
