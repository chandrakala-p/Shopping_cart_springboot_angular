import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  public baseUrl = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) {

  }

  public getItems(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/getAllItems/`);
  }

  public getItem(id: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/getItemById/${id}`);
  }

  public deleteItem(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/deleteItemById/${id}`, { responseType: 'text' });
  }

  public updateItem(value: any): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}/updateItem/`, value);
  }

  public addItem(user: object): Observable<object> {
    return this.httpClient.post(`${this.baseUrl}/addItem`, user);
  }

}

