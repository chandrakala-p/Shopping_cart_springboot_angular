import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id!: number;
  user!: User;
  submitted = false;

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.user = new User();
    this.id = this.route.snapshot.params['id'];
    this.userService.getUser(this.id).subscribe(data => {
      this.user = data;
      console.log(data);
    },
      error => console.log(error));
  }

  editUser() {
    console.log("update", this.user)
    this.userService.updateUser(this.user).
      subscribe((data: any) => console.log(data), (error: any) => console.log(error));
    this.user = new User();


    this.usersList();

  }

  onSubmit() {
    this.submitted = true;
    this.editUser();
  }

  usersList() {
    this.router.navigate(['users']);
  }

}
