import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabMenuModule } from 'primeng/tabmenu';
import { PaginatorModule } from 'primeng/paginator';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    TabMenuModule,
    PaginatorModule
  ],
  exports: [
    TabMenuModule,
    PaginatorModule
  ]
})
export class UserInterfaceModule { }
