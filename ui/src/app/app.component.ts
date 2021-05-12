import { Component } from '@angular/core';

import { AppService } from './app.service';
import {Football} from "./classes/football";
import {Observable} from "rxjs";
import {Matchplayed} from "./classes/matchplayed";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  postRequestResponse: string;
  footballClubs:Football[];
  matchesPlayed:Matchplayed[];
  randomMatchPlayed:Matchplayed[];



  constructor(private appService: AppService) {
  }

  ngOnInit(){
    this.appService.getFootballClubData().subscribe(
      (data:Football[])=>{
        console.log(data);
        this.footballClubs=data;
      }
    );


    this.appService.getMatchesPlayedData().subscribe(
      (data:Matchplayed[])=>{
        console.log(data);
        this.matchesPlayed=data;
      }
    );
  }

  selectChangeHandler (event: any) {
    let selection=event.target.value;
    if(selection=="wins"){
      this.appService.getFootballClubWinsSortedData().subscribe(
        (data:Football[])=>{
          console.log(data);
          this.footballClubs=data;
        });
    }else if(selection=="goals"){
      this.appService.getFootballClubGoalsSortedData().subscribe(
        (data:Football[])=>{
          console.log(data);
          this.footballClubs=data;
        });
    }else if(selection=="points"){
      this.appService.getFootballClubData().subscribe(
        (data:Football[])=>{
          console.log(data);
          this.footballClubs=data;
        }
      );
    }
  }

  sort(){
    this.appService.getSortedMatchesPlayedData().subscribe(
      (data:Matchplayed[])=>{
        console.log(data);
        this.matchesPlayed=data;
      }
    );
  }

  getSearchVal(item){
    console.log(item.value);
    let searchVal=item.value;
    let searchList=this.matchesPlayed.filter(item=>item.matchPlayedDate.date==searchVal);
    console.log(searchList);
    this.matchesPlayed=searchList;
  }

  generate(){
    this.appService.getRandomMatchPlayed().subscribe(
      (data:Matchplayed[])=>{
        console.log(data);
        this.randomMatchPlayed=data;
        //this.matchesPlayed.push(this.matchesPlayed[0]);
      }
    );

  }


  /**
   * This method is used to test the post request
   */
  public postData(): void {
    this.appService.sendData().subscribe((data: any) => {
      this.postRequestResponse = data.content;
    });
  }
}
