import {Football} from "./football";
import {Date} from "./date";


export class Matchplayed{
  private _awayTeam:Football;
  private _homeTeam:Football;
  private _matchPlayedDate:Date;
  private _noOfGoalsScoredByAwayTeam:number;
  private _noOfGoalsScoredByHomeTeam:number;


  get homeTeam(): Football {
    return this._homeTeam;
  }

  set homeTeam(value: Football) {
    this._homeTeam = value;
  }

  get awayTeam(): Football {
    return this._awayTeam;
  }

  set awayTeam(value: Football) {
    this._awayTeam = value;
  }

  get noOfGoalsScoredByHomeTeam(): number {
    return this._noOfGoalsScoredByHomeTeam;
  }

  set noOfGoalsScoredByHomeTeam(value: number) {
    this._noOfGoalsScoredByHomeTeam = value;
  }

  get noOfGoalsScoredByAwayTeam(): number {
    return this._noOfGoalsScoredByAwayTeam;
  }

  set noOfGoalsScoredByAwayTeam(value: number) {
    this._noOfGoalsScoredByAwayTeam = value;
  }

  get matchPlayedDate(): Date {
    return this._matchPlayedDate;
  }

  set matchPlayedDate(value: Date) {
    this._matchPlayedDate = value;
  }
}
