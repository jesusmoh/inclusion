import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyService {

  constructor(private http: HttpClient) { }

  postRequest(numbers: any): Observable<any> {
    const url = 'http://localhost:8081/app/service/findk';
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const body = JSON.stringify({
      x: numbers.x,
      y: numbers.y,
      n: numbers.n
    });

    return this.http.post(url, body, { headers: headers });
  }
}
