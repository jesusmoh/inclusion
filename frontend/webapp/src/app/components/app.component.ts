import { Component, OnInit } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { MyService } from '../services/my-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { IResult } from '../interfaces/in/IResult';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  ip: string = "";
  k: any = "";
  numbers = { x: '', y: '', n: '' };
  result: IResult = { timestamp: "", status: 200, error: "", message: "", path: "", k: -1 };

  constructor(private myService: MyService, private http: HttpClient, private router: Router) { }

  ngOnInit() {

    if (typeof window !== 'undefined') {
      console.log(window.location.hostname);
      this.ip = window.location.hostname;
    }

  }

  public sendPostRequest() {
    this.myService.postRequest(this.numbers, this.ip).subscribe(
      result => {
        console.log(result);
        if (result.k) {
          this.k = result.k;

        } else {
          this.result = result;
          this.k = "";
        }
      },
      error => {
        this.k = "";
        this.result = error.error;
      }
    );
  }
}
