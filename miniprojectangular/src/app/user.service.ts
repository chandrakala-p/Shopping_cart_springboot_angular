import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  public baseUrl = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) {

  }

  public getUsers(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/getAllUsers/`);
  }

  public getUser(id: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/getUserById/${id}`);
  }

  public deleteUser(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/deleteUserById/${id}`, { responseType: 'text' });
  }

  public updateUser(value: any): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}/updateUser/`, value);
  }

  public addUser(user: object): Observable<object> {
    return this.httpClient.post(`${this.baseUrl}/register`, user);
  }

}

