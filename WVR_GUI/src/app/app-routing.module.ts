import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarFormComponent } from './car-form/car-form.component';
import { BikeFormComponent } from './bike-form/bike-form.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';



const routes: Routes = [
  {
    path:"car-form",
    component:CarFormComponent
  },
  {
    path:"bike-form",
    component:BikeFormComponent
  },{
    path:"customer-form",
    component:CustomerFormComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
