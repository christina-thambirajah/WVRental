import { Injectable } from "@angular/core";
import {HttpClient
} from "@angular/common/http";

import { Schedule } from "../car-form/car-form.component";
import { Schedule1} from "../bike-form/bike-form.component";
import { Customer } from '../customer-form/customer-form.component';


@Injectable({
  providedIn: "root"
})

export class DataServiceService {
  
  private headers: Headers = new Headers({});

  MakeBooking(schedule: Schedule){
    return this.http.post(
      "http://localhost:8080/vehiclesCars/carSchedules",
      schedule
    )
  }
  MakeBikeBooking(schedule1: Schedule1){
    return this.http.post(
      "http://localhost:8080/vehiclesBikes/bikeSchedules",
      schedule1

    )
  }
  AddCustomer(customer: Customer) {
    return this.http.post(
      "http://localhost:8080/customers/customerDetails",
      customer
    )
  }

  
  constructor(private http: HttpClient) {
  }
}


