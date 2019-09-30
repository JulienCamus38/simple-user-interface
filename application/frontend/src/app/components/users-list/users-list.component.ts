import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users: User[];

  reverse: boolean;

  userSearch;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.updateUsersList();
    this.reverse = false;
  }

  updateUsersList() {
    this.userService.findAll().subscribe(data => { this.users = data; });
  }

  gotoUsersList() {
    this.router.navigate(['/users']);
  }

  deleteUser(id: number) {
    this.userService.remove(id).subscribe(result => {
      this.updateUsersList();
      this.gotoUsersList();
    });
  }

  updateUsersListGroupByGroupId() {
    this.userService.findAllGroupByGroupId().subscribe(data => {
      if (this.reverse) {
        this.users = data.reverse();
      } else {
        this.users = data;
      }
      this.reverse = !this.reverse;
    });
  }

}
