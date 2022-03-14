import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Deal } from './deal';
import { DEALS } from './deal_list';

@Injectable({
  providedIn: 'root'
})
export class DealService {

  ApiDlabsUrl = 'http://localhost:8080/singlepage';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {}

  getDeals(): Observable<Deal[]>{
    const url = `${this.ApiDlabsUrl}/all`;
    return this.http.get<Deal[]>(url).pipe(
      tap(_ => console.log(`GET data from: ${url}`)),
      catchError(this.handleError<Deal[]>(`GET`, DEALS))
    );
  }

  getDeal(id: number): Observable<Deal>{
    const url = `${this.ApiDlabsUrl}/${id}`;
    return this.http.get<Deal>(url).pipe(
      tap(_ => console.log(`GET data from: ${url}`)),
      catchError(this.handleError<Deal>(`GET`, DEALS[0]))
    );
  }

  addDeal(deal: Deal): Observable<Deal> {
    const url = `${this.ApiDlabsUrl}/add`;
    return this.http.post<Deal>(url, deal, this.httpOptions).pipe(
      tap(_ => console.log(`POST data to: ${url}`)),
      catchError(this.handleError<Deal>(`POST`, deal))
    );
  }

  updateDeal(deal: Deal): Observable<any> {
    const url = this.ApiDlabsUrl;
    return this.http.put(url, deal, this.httpOptions).pipe(
      tap(_ => console.log(`PUT data to: ${url}`)),
      catchError(this.handleError<any>(`PUT`, deal))
    );
  }

  deleteDeal(id: number): Observable<Deal> {
    const url = `${this.ApiDlabsUrl}/${id}`;
  
    return this.http.delete<Deal>(url, this.httpOptions).pipe(
      tap(_ => console.log(`DELETE data from: ${url}`)),
      catchError(this.handleError<Deal>(`DELETE`, id))
    );
  }

  private handleError<T>(operation = 'operation', result?: T | number) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead

      switch(operation){
        case 'GET':{
          console.log('Try to GET data from distant server failed')
          break;
        }
        case 'POST':{
          console.log('Try to POST data to distant server failed')
          break;
        }
        default:{
          console.log(`not implemented yet`)
          break;
        }
      }
  
      // Let the app keep running by returning a default result.
      return of(result as T);
    };
  }
}
