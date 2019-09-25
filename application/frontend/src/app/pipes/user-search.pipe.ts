import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../models/user';

@Pipe({
  name: 'userSearch'
})
export class UserSearchPipe implements PipeTransform {

  transform(users: User[], id: number, name: string, groupId: string) {
    if (users && users.length) {
      return users.filter(user => {
        if (id && !user.id.toString().includes(id.toString())) {
          return false;
        }
        if (name && !user.name.toLowerCase().includes(name.toLowerCase())) {
          return false;
        }
        if (groupId && !user.groupId.toLowerCase().includes(groupId.toLowerCase())) {
          return false;
        }
        return true;
      });
    } else {
      return users;
    }
  }

}
