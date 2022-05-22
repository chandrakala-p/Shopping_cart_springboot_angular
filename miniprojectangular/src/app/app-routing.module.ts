import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from './component/add-item/add-item.component';
import { AddOrderComponent } from './component/add-order/add-order.component';
import { AddUserComponent } from './component/add-user/add-user.component';
import { ItemDetailsComponent } from './component/item-details/item-details.component';
import { ItemListComponent } from './component/item-list/item-list.component';
import { OrderDetailsComponent } from './component/order-details/order-details.component';
import { OrderListComponent } from './component/order-list/order-list.component';
import { UpdateItemComponent } from './component/update-item/update-item.component';
import { UpdateOrderComponent } from './component/update-order/update-order.component';
import { UpdateUserComponent } from './component/update-user/update-user.component';
import { UserDetailsComponent } from './component/user-details/user-details.component';
import { UserListComponent } from './component/user-list/user-list.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'users' },
  { path: 'users', component: UserListComponent },
  { path: 'addUser', component: AddUserComponent },
  { path: 'user/:id', component: UserDetailsComponent },
  { path: 'update/:id', component: UpdateUserComponent },

  { path: 'orders', component: OrderListComponent },
  { path: 'addOrder', component: AddOrderComponent },
  { path: 'order/:id', component: OrderDetailsComponent },
  { path: 'updateOrder/:id', component: UpdateOrderComponent },


  { path: 'addItem', component: AddItemComponent },
  { path: 'items', component: ItemListComponent },
  { path: 'item/:id', component: ItemDetailsComponent },
  { path: 'updateItem/:id', component: UpdateItemComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
