


export class Football{
  private _name:string;
  private _location:string;
  private _wins:number;
  private _draws:number;
  private _defeats:number;
  private _noOfGoalsScored:number;
  private _noOfGoalsConceded:number;
  private _noOfPoints:number;
  private _noOfMatchesPlayed:number;


  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get location(): string {
    return this._location;
  }

  set location(value: string) {
    this._location = value;
  }

  get wins(): number {
    return this._wins;
  }

  set wins(value: number) {
    this._wins = value;
  }

  get draws(): number {
    return this._draws;
  }

  set draws(value: number) {
    this._draws = value;
  }

  get defeats(): number {
    return this._defeats;
  }

  set defeats(value: number) {
    this._defeats = value;
  }

  get noOfGoalsScored(): number {
    return this._noOfGoalsScored;
  }

  set noOfGoalsScored(value: number) {
    this._noOfGoalsScored = value;
  }

  get noOfGoalsConceded(): number {
    return this._noOfGoalsConceded;
  }

  set noOfGoalsConceded(value: number) {
    this._noOfGoalsConceded = value;
  }

  get noOfPoints(): number {
    return this._noOfPoints;
  }

  set noOfPoints(value: number) {
    this._noOfPoints = value;
  }

  get noOfMatchesPlayed(): number {
    return this._noOfMatchesPlayed;
  }

  set noOfMatchesPlayed(value: number) {
    this._noOfMatchesPlayed = value;
  }
}
