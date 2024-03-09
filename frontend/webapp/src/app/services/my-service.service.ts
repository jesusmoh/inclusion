import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { INumbers } from '../interfaces/out/INumbers';
import { IResult } from '../interfaces/in/IResult';

@Injectable({
  providedIn: 'root'
})
export class MyService {

  constructor(private http: HttpClient) { }

  postRequest(numbers: INumbers, ip: string): Observable<IResult> {
    const url = 'http://' + ip + ':8081/app/service/findk';
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<IResult>(url, numbers, { headers: headers });
  }
}
