import {Football} from "./football";


export class Date{
  private _day:number;
  private _month:number;
  private _year:number;
  private _date:string;


  get day(): number {
    return this._day;
  }

  set day(value: number) {
    this._day = value;
  }

  get month(): number {
    return this._month;
  }

  set month(value: number) {
    this._month = value;
  }

  get year(): number {
    return this._year;
  }

  set year(value: number) {
    this._year = value;
  }

  get date(): string {
    return this._date;
  }

  set date(value: string) {
    this._date = value;
  }

  getString():string{
    let stringDate:string;
    if(this._day<10){
      stringDate="0";
    }
    stringDate=stringDate+this._day;
    stringDate=stringDate+"/";
    if(this._month<10){
      stringDate=stringDate+"0";
    }
    stringDate=stringDate+this._month;
    stringDate=stringDate+"/";
    stringDate=stringDate+this._year;

    return stringDate;
  }
}
