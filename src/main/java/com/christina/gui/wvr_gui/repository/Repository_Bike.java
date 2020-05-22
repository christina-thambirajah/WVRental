package com.christina.gui.wvr_gui.repository;

import com.christina.gui.wvr_gui.model.ModelBike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_Bike extends JpaRepository<ModelBike,String> {
}
