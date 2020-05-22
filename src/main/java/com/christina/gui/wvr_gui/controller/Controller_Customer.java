package com.christina.gui.wvr_gui.controller;

import com.christina.gui.wvr_gui.model.ModelCustomer;
import com.christina.gui.wvr_gui.repository.Repository_Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class Controller_Customer {

    @Autowired
    private Repository_Customer repoCustomer;
    @PostMapping("/customerDetails")
    public ModelCustomer insert(@RequestBody ModelCustomer modelCustomer){
        System.out.println(modelCustomer);
        { return (this.repoCustomer.save(modelCustomer)); }
    }
}
