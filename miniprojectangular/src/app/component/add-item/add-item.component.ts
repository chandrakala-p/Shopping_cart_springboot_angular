import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from 'src/app/item';
import { ItemService } from 'src/app/item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  item: Item = new Item();

  submitted = false;

  constructor(private itemService: ItemService, private router: Router) { }

  ngOnInit() {

  }

  newItem(): void {
    this.submitted = false;
    this.item = new Item();
  }

  save() {
    this.itemService.addItem(this.item)
      .subscribe(data => console.log(data), error => console.log(error));
    this.item = new Item();
    this.itemsList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }


  itemsList() {
    this.router.navigate(['items']);
  }


}