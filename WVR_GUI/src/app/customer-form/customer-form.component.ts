import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../Service/data-service.service';

export class Customer{
  customerID:String;
  address:String;
  contactNo:String;
  fName:String;
  lName:String;
  nicNo:String;
}

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {
  [x: string]: any;

  customer: Customer;
  customers: Customer;
  customerID
  address;
  contactNo;
  fName;
  lName;
  nicNo;

  constructor( private service : DataServiceService) { }

  ngOnInit() {
  }
  AddCustomer(){
    this.customer = new Customer();
    this.customer.customerID = this.customerID;
    this.customer.address = this.address;
    this.customer.contactNo = this.contactNo;
    this.customer.fName = this.fName;
    this.customer.lName = this.lName;
    this.customer.nicNo = this.nicNo;

    this.service.AddCustomer(this.customer).subscribe(
      Response => console.log(Response),
      error => console.log(error));
}
}