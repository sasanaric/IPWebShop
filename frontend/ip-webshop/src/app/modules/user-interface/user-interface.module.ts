import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabMenuModule } from 'primeng/tabmenu';
import { PaginatorModule } from 'primeng/paginator';
import { DropdownModule } from 'primeng/dropdown';
import { InputNumberModule } from 'primeng/inputnumber';
import { ButtonModule } from 'primeng/button';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    TabMenuModule,
    PaginatorModule,
    DropdownModule,
    InputNumberModule,
    ButtonModule
  ],
  exports: [
    TabMenuModule,
    PaginatorModule,
    DropdownModule,
    InputNumberModule,
    ButtonModule
  ]
})
export class UserInterfaceModule { }
