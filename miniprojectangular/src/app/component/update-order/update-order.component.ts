import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/order.service';

@Component({
  selector: 'app-update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit {


  id!: number;
  order!: Order;
  submitted = false;

  constructor(private orderService: OrderService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.order = new Order();
    this.id = this.route.snapshot.params['id'];
    this.orderService.getOrder(this.id).subscribe(data => {
      this.order = data;
      console.log(data);
    },
      error => console.log(error));
  }

  editOrder() {
    console.log("updateOrder", this.order)
    this.orderService.updateOrder(this.order).
      subscribe((data: any) => console.log(data), (error: any) => console.log(error));
    this.order = new Order();


    this.ordersList();

  }

  onSubmit() {
    this.submitted = true;
    this.editOrder();
  }

  ordersList() {
    this.router.navigate(['orders']);
  }

}