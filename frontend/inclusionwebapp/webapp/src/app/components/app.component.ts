import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MyService } from '../services/my-service.service';
import { FormsModule } from '@angular/forms';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  title = 'sample text';
  k: any = "";
  numbers = { x: '', y: '', n: '' };
  badresultk = "";

  constructor(private myService: MyService) { }


  ngOnInit() {

  }

  public sendPostRequest() {
    this.badresultk = "";
    this.myService.postRequest(this.numbers).subscribe(
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
