import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/models/user';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Accept', 'application/json');
  httpOptions = {
    headers: this.headers
  };

  constructor(private httpClient: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  private handleError(error: any) {
    console.error(error);
    return throwError(error);
  }

  public findAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.usersUrl);
  }

  public save(user: User) {
    return this.httpClient.post<User>(this.usersUrl, user);
  }

  public remove(id: number) {
    const url = `${this.usersUrl}/${id}`;
    return this.httpClient.delete(url, this.httpOptions)
      .pipe(catchError(this.handleError));
  }

}
