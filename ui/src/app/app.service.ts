import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';

/**
 * Class representing application service.
 *
 * @class AppService.
 */
@Injectable()
export class AppService {
  private footballClubsUrl = '/api/footballClubs';
  private dataPostTestUrl = '/api/postTest';
  private winsSortUrl = '/api/winsSorted';
  private goalsSortUrl = '/api/goalsSorted';
  private matchesPlayedUrl = '/api/matchesPlayed';
  private sortedMatchesPlayedUrl = '/api/sortedMatchesPlayed';
  private randomMatchUrl = '/api/randomMatch ';

  constructor(private http: HttpClient) {
  }

  /**
   * Makes a http get request to retrieve the welcome message from the backend service.
   */
  public getFootballClubData():Observable<any> {
    return this.http.get(this.footballClubsUrl);
  }

  public getFootballClubWinsSortedData():Observable<any> {
    return this.http.get(this.winsSortUrl);
  }

  public getFootballClubGoalsSortedData():Observable<any> {
    return this.http.get(this.goalsSortUrl);
  }

  public getMatchesPlayedData():Observable<any> {
    return this.http.get(this.matchesPlayedUrl);
  }

  public getSortedMatchesPlayedData():Observable<any> {
    return this.http.get(this.sortedMatchesPlayedUrl);
  }

  public searchMatchesPlayed(date):Observable<any> {
    return this.http.get('/api/'+date);
  }

  public getRandomMatchPlayed():Observable<any> {
    return this.http.get(this.randomMatchUrl);
  }


  /**
   * Makes a http post request to send some data to backend & get response.
   */
  public sendData(): Observable<any> {
    return this.http.post(this.dataPostTestUrl, {});
  }
}
