import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello',
  standalone: true,
  imports: [],
  templateUrl: './hello.component.html',
  styleUrl: './hello.component.css'
})
export class HelloComponent implements OnInit {

  message: String = "Nothing"

  constructor(private readonly httpClient: HttpClient) {
  }


  ngOnInit(): void {
    this.httpClient.get<string>("http://localhost:9080/hello").subscribe((response: string) => {
      this.message = response;
    });
  }


}
