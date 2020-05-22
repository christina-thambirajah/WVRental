package com.christina.gui.wvr_gui.repository;

import com.christina.gui.wvr_gui.model.ModelSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_Schedule extends JpaRepository<ModelSchedule,String> {
}
