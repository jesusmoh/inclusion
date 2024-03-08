import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MyService } from '../services/my-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  title = 'sample text';
  ip: string = "";
  k: any = "";
  numbers = { x: '', y: '', n: '' };
  badresultk = "";

  constructor(private myService: MyService, private http: HttpClient, private router: Router) { }


  ngOnInit() {

    console.log(window.location.host);
    this.ip = window.location.host;
  }

  public sendPostRequest() {
    this.badresultk = "";
    this.myService.postRequest(this.numbers, this.ip).subscribe(
      result => {
        console.log(result);
        if (result.k) {
          this.k = result.k;

        } else {
          this.badresultk = JSON.stringify(result);
        }
      },
      error => {
        this.badresultk = JSON.stringify(error.error);
      }
    );
  }
}
