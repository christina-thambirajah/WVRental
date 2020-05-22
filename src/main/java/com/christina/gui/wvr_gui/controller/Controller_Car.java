package com.christina.gui.wvr_gui.controller;

import com.christina.gui.wvr_gui.model.ModelCar;
import com.christina.gui.wvr_gui.model.ModelSchedule;
import com.christina.gui.wvr_gui.repository.Repository_Car;
import com.christina.gui.wvr_gui.repository.Repository_Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//the link the Angular project will be deployed in
@CrossOrigin(origins = "http://localhost:4200")

@RestController
//path set to post the values taken from the database
@RequestMapping("/vehiclesCars")
public class Controller_Car {
    @Autowired
    //used to provide control
    private Repository_Car repoCar;
    @Autowired
    private Repository_Schedule repoSchedule;
    public Controller_Car(Repository_Car repoCar){
        this.repoCar = repoCar;
    }
    @GetMapping("/cars")
    //setting the path for the backend to be posted
    public Iterable<ModelCar> getCar(){return (repoCar.findAll());
    }
    @PostMapping
    public ModelCar insert(@RequestBody ModelCar modelCar){
        return (this.repoCar.save(modelCar));
    }

    @PostMapping("/carSchedules")
    public ModelSchedule insert(@RequestBody ModelSchedule modelSchedule){
        System.out.println(modelSchedule);
        { return (this.repoSchedule.save(modelSchedule)); }
    }
}
