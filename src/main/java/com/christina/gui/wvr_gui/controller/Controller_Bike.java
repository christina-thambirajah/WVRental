package com.christina.gui.wvr_gui.controller;
import com.christina.gui.wvr_gui.model.ModelBike;
import com.christina.gui.wvr_gui.model.ModelSchedule;
import com.christina.gui.wvr_gui.repository.Repository_Bike;
import com.christina.gui.wvr_gui.repository.Repository_Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vehiclesBikes")
public class Controller_Bike {

    @Autowired
    private Repository_Bike repoBike;
    @Autowired
    private Repository_Schedule repoSchedule;
    public Controller_Bike(Repository_Bike repoBike){
        this.repoBike = repoBike;
    }
    @GetMapping("/bikes")
    public Iterable<ModelBike> getBike(){return (repoBike.findAll());
    }
    @PostMapping
    public ModelBike insert(@RequestBody ModelBike modelBike){
        return (this.repoBike.save(modelBike));
    }

    @PostMapping("/bikeSchedules")
    public ModelSchedule insert(@RequestBody ModelSchedule modelSchedule){
        System.out.println(modelSchedule);
        { return (this.repoSchedule.save(modelSchedule)); }
    }
}
