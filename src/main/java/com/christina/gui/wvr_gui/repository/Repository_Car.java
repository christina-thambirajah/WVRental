package com.christina.gui.wvr_gui.repository;

import com.christina.gui.wvr_gui.model.ModelCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_Car extends JpaRepository<ModelCar,String> {


}
