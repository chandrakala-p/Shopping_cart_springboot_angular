import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from 'src/app/item';
import { ItemService } from 'src/app/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items!: Item[];
  id!: number;
  item: Item = new Item();

  isLoading = true;
  color = 'primary';
  mode = 'determinate';
  value = 50;
  displayedColumns = ['itemName', 'itemPrice', 'action', 'actionu', 'actiond'];
  itemName: any;

  constructor(private itemService: ItemService, private router: Router,) { }

  ngOnInit() {

    this.itemService.getItems().subscribe(data => {
      console.log(data);
      this.items = data;
      this.isLoading = false;
    })
  }

  itemDetails(id: number) {
    this.router.navigate(['item', id]);
    console.log(id);
  }

  deleteItem(id: number) {
    this.itemService.deleteItem(id).
      subscribe(data => {
        console.log(data);
        this.ngOnInit();
      },
        error => console.log(error));
  }

  editItem(id: number) {
    this.router.navigate(['updateItem', id]);
    console.log(id);
  }

  addItem() {
    this.router.navigate(['addItem']);
  }

  search() {
    this.isLoading = true;
    this.items = this.items.filter(res => {
      if (!this.items) {
        this.itemService.getItems().subscribe(data => {
          this.items = data;
          console.log(data);
        })
      }
      else {
        (error: any) => console.log(error);
      }
      return res.itemName.toLocaleLowerCase().match(this.itemName.toLocaleLowerCase());
    })
  }



}
