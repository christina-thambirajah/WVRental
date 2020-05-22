package com.christina.gui.wvr_gui.repository;

import com.christina.gui.wvr_gui.model.ModelCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_Customer extends JpaRepository<ModelCustomer,String> {
}
