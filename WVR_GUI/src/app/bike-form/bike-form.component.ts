import { Component, OnInit } from '@angular/core';
import {DataServiceService} from "../Service/data-service.service" ;
import {HttpClient} from '@angular/common/http';

export class Schedule1{
  bookingID:String;
  plate_Number:String;
  customerID:String;
  pickupDate:Date;
  dropoffDate:Date;
}

interface viewBikes{
  plate_Number:String;
  make :String;
  model :String;
  color :String;
  ratePerDay :number;
  hasStorage :boolean;
  isScooterType :boolean;
}

@Component({
  selector: 'app-bike-form',
  templateUrl: './bike-form.component.html',
  styleUrls: ['./bike-form.component.css']
})
export class BikeFormComponent implements OnInit {

  schedule: Schedule1;
  schedules: Schedule1;
  bookingID;
  plate_Number;
  customerID;
  pickupDate;
  dropoffDate;
  data:Object;


  constructor(private service : DataServiceService,
    private http:HttpClient) { }

getBikes: viewBikes[] = [];//arraylist



  ngOnInit() {
    //url
    var bike_URL = "http://localhost:8080/vehiclesBikes/bikes";
    this.http.get<viewBikes[]>(bike_URL).subscribe(
      value=>{
      this.getBikes= value;
    });
  }

  MakeBikeBooking(){
    this.schedule = new Schedule1();
    this.schedule.bookingID = this.bookingID;
    this.schedule.plate_Number = this.plate_Number;
    this.schedule.customerID = this.customerID;
    this.schedule.pickupDate = this.pickupDate;
    this.schedule.dropoffDate = this.dropoffDate;
    this.service.MakeBikeBooking(this.schedule).subscribe(
      Response => console.log(Response),
      error => console.log(error));

}

}
