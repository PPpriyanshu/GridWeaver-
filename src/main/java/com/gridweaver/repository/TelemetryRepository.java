package com.gridweaver.repository;

import com.gridweaver.entity.Telemetry;
import org.springframework.data.jpa.repository.*;
import java.util.List;
import java.util.Optional;


public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
    List<Telemetry> findByDeviceId(Long deviceId);
    Optional<Telemetry> findTopByDevice_IdOrderByTimestampDesc(Long deviceId);
    
}
