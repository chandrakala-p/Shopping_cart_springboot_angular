import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public baseUrl = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) {

  }

  public getOrders(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/getAllOrders/`);
  }

  public getOrder(id: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/getOrderById/${id}`);
  }

  public deleteOrder(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/deleteOrderById/${id}`, { responseType: 'text' });
  }

  public updateOrder(value: any): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}/updateOrder/`, value);
  }

  public addOrder(user: object): Observable<object> {
    return this.httpClient.post(`${this.baseUrl}/addOrder`, user);
  }

}

