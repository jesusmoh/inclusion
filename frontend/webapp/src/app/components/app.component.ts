import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MyService } from '../services/my-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


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

  constructor(private myService: MyService, private http: HttpClient) { }


  ngOnInit() {
    this.getIpAddress();
  }

  getIpAddress() {
    this.http.get<{ ip: string }>('https://api.ipify.org?format=json')
      .subscribe(data => {
        console.log('IP Address: ', data.ip);
        this.ip = data.ip;
        // You can now use the IP address as needed
      }, error => {
        console.error('Failed to get IP address:', error);
      });
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
