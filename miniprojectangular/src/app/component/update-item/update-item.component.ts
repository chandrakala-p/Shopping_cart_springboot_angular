import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from 'src/app/item';
import { ItemService } from 'src/app/item.service';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {

  id!: number;
  item!: Item;
  submitted = false;

  constructor(private itemService: ItemService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.item = new Item();
    this.id = this.route.snapshot.params['id'];
    this.itemService.getItem(this.id).subscribe(data => {
      this.item = data;
      console.log(data);
    },
      error => console.log(error));
  }

  editOrder() {
    console.log("updateItem", this.item)
    this.itemService.updateItem(this.item).
      subscribe((data: any) => console.log(data), (error: any) => console.log(error));
    this.item = new Item();


    this.itemsList();

  }

  onSubmit() {
    this.submitted = true;
    this.editOrder();
  }

  itemsList() {
    this.router.navigate(['items']);
  }

}