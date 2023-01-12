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
  private stocksList: Stock[] | undefined;

  constructor(private readonly httpClient: HttpClient) {
    private URL_STOCKS = 'http://localhost:52001';
  }

  // @ts-ignore
  getAllStocks() {
    const url = `${this.URL_STOCKS}/stocks`;
    return this.httpClient.get<Stock[]>(url);
  }

  ngOnInit = (): void => {
    this.getAllStocks()
        .pipe()
        .subscribe( value => {
          this.stocksList = value;
        });
  };

}
