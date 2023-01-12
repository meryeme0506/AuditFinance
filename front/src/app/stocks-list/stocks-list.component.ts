import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Stock} from "./Stock";

@Component({
  selector: 'app-stocks-list',
  templateUrl: './stocks-list.component.html',
  styleUrls: ['./stocks-list.component.css']
})
export class StocksListComponent implements OnInit {
  private stocksList: Stocks[] | undefined;

  constructor(private readonly httpClient: HttpClient) {
    url : private URL_STOCKS = 'http://localhost:52001';
    stocksList: Stocks[];
  }

  getAllStocks(): Observable<Stocks[]> {
    const url = `${this.URL_STOCKS}/stocks`;
    return this.httpClient.get<Stocks[]>(url);
  }

  ngOnInit(): void {
    this.getAllStocks()
        .pipe()
        .subscribe( value => {
          this.stocksList = value;
        });
  }

}
