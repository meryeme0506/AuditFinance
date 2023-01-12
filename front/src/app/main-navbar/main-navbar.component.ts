import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Component({
  selector: 'app-main-navbar',
  templateUrl: './main-navbar.component.html',
  styleUrls: ['./main-navbar.component.css']
})
export class MainNavbarComponent implements OnInit {

  user = "blabla";
  data : any;

  elements = [1, 2, 3, 4, 5];

  constructor(private http : HttpClient) { }

  getStockData() {
    const API_KEY = '1XDCVS7DM3C1XE20';
    const SYMBOL = 'IBM';
    const API_URL = 'https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=${SYMBOL}&apikey=${API_KEY}';
    this.http.get(API_URL).subscribe((res : any) => {
      console.log(res);
    });
  }

  getData() : Observable<any>{
    const API_KEY = '1XDCVS7DM3C1XE20';
    const SYMBOL = 'IBM';
    const API_URL = 'https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=${SYMBOL}&apikey=${API_KEY}';
    return this.http.get(API_URL)
  };

  ngOnInit(): void {
  }

}
