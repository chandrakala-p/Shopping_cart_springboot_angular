import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddUserComponent } from './component/add-user/add-user.component';
import { UserListComponent } from './component/user-list/user-list.component';
import { UpdateUserComponent } from './component/update-user/update-user.component';
import { UserDetailsComponent } from './component/user-details/user-details.component';
import { AddOrderComponent } from './component/add-order/add-order.component';
import { OrderListComponent } from './component/order-list/order-list.component';
import { UpdateOrderComponent } from './component/update-order/update-order.component';
import { OrderDetailsComponent } from './component/order-details/order-details.component';
import { AddItemComponent } from './component/add-item/add-item.component';
import { ItemDetailsComponent } from './component/item-details/item-details.component';
import { ItemListComponent } from './component/item-list/item-list.component';
import { UpdateItemComponent } from './component/update-item/update-item.component';


@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    UserListComponent,
    UpdateUserComponent,
    UserDetailsComponent,
    AddOrderComponent,
    OrderListComponent,
    UpdateOrderComponent,
    OrderDetailsComponent,
    AddItemComponent,
    ItemDetailsComponent,
    ItemListComponent,
    UpdateItemComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
