package com.whisperlink.whisperlink.dao;
import com.whisperlink.whisperlink.models.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {


    //    // Complex query for two parameters
    @Query("SELECT l FROM Location l WHERE l.address = :address")
    List<Location> findByAddress(@Param("address") String address);

}
