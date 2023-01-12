import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StockServiceService {

  private URL_AlphaVantage = 'https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=IBM&apikey=1XDCVS7DM3C1XE20';
  constructor(private httpClient: HttpClient) { }

  getAllStocks() {
    return this.httpClient.get(this.URL_AlphaVantage);
  }
}
