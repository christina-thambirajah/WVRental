import { Component, OnInit } from '@angular/core';
import {DataServiceService} from "../Service/data-service.service" ;
import {HttpClient} from '@angular/common/http';


export class Schedule{
  bookingID:String;
  plate_Number:String;
  customerID:String;
  pickupDate:Date;
  dropoffDate:Date;
}

interface viewCars{
  plate_Number:String;
  make :String;
  model :String;
  color :String;
  ratePerDay :number;
  hasAC :boolean;
  noOfSeats :number;
}

@Component({
  selector: 'app-car-form',
  templateUrl: './car-form.component.html',
  styleUrls: ['./car-form.component.css']
})

export class CarFormComponent implements OnInit {

  schedule: Schedule;
  schedules: Schedule;
  bookingID;
  plate_Number;
  customerID;
  pickupDate;
  dropoffDate;
  data:Object;


  constructor(
    private service : DataServiceService,
    private http:HttpClient){ }

    getCars: viewCars[] = [];//arraylist



  ngOnInit() {
    //url
    var car_URL = "http://localhost:8080/vehiclesCars/cars";
    this.http.get<viewCars[]>(car_URL).subscribe(
      value=>{
      this.getCars= value;
    });
  }
      MakeBooking(){
        this.schedule = new Schedule();
        this.schedule.bookingID = this.bookingID;
        this.schedule.plate_Number = this.plate_Number;
        this.schedule.customerID = this.customerID;
        this.schedule.pickupDate = this.pickupDate;
        this.schedule.dropoffDate = this.dropoffDate;
        this.service.MakeBooking(this.schedule).subscribe(
          Response => console.log(Response),
          error => console.log(error));

}
}