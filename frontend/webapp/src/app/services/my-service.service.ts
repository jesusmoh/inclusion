import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyService {

  constructor(private http: HttpClient) { }

  postRequest(numbers: any, ip: string): Observable<any> {
    const url = 'http://' + ip + '/app/service/findk';
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const body = JSON.stringify({
      x: numbers.x,
      y: numbers.y,
      n: numbers.n
    });

    return this.http.post(url, body, { headers: headers });
  }
}
