import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders!: Order[];
  id!: number;
  order: Order = new Order();

  isLoading = true;
  color = 'primary';
  mode = 'determinate';
  value = 50;
  displayedColumns = ['userName', 'password', 'action', 'actionu', 'actiond'];
  orderName: any;

  constructor(private orderService: OrderService, private router: Router,) { }

  ngOnInit() {

    this.orderService.getOrders().subscribe(data => {
      console.log(data);
      this.orders = data;
      this.isLoading = false;
    })
  }

  orderDetails(id: number) {
    this.router.navigate(['order', id]);
    console.log(id);
  }

  deleteOrder(id: number) {
    this.orderService.deleteOrder(id).
      subscribe(data => {
        console.log(data);
        this.ngOnInit();
      },
        error => console.log(error));
  }

  editOrder(id: number) {
    this.router.navigate(['updateOrder', id]);
    console.log(id);
  }

  addOrder() {
    this.router.navigate(['addOrder']);
  }

  search() {
    this.isLoading = true;
    this.orders = this.orders.filter(res => {
      if (!this.orders) {
        this.orderService.getOrders().subscribe(data => {
          this.orders = data;
          console.log(data);
        })
      }
      else {
        (error: any) => console.log(error);
      }
      return res.orderName.toLocaleLowerCase().match(this.orderName.toLocaleLowerCase());
    })
  }



}
