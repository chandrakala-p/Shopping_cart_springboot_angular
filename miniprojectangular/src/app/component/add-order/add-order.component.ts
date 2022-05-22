import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/order.service';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  order: Order = new Order();

  submitted = false;

  constructor(private userService: OrderService, private router: Router) { }

  ngOnInit() {

  }



  save() {
    this.userService.addOrder(this.order)
      .subscribe(data => console.log(data), error => console.log(error));
    this.order = new Order();
    this.ordersList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }


  ordersList() {
    this.router.navigate(['orders']);
  }

}
