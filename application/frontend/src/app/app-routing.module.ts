import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersListComponent } from 'src/app/components/users-list/users-list.component';
import { UserFormComponent } from 'src/app/components/user-form/user-form.component';


const routes: Routes = [
  { path: 'users', component: UsersListComponent },
  { path: 'adduser', component: UserFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
