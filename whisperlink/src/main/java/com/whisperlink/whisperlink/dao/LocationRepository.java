package com.whisperlink.whisperlink.dao;
import com.whisperlink.whisperlink.models.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    // Complex query with 3 parameters
    @Query("SELECT l FROM Location l WHERE l.address = :address AND l.id = :id AND l.city = :city")
    List<Location> findByAddress(@Param("address") String address,@Param("id") Long id,@Param("city") String city );

    //complex query with 2 parameters (name and postal code)
    @Query("SELECT l FROM Location l WHERE l.address = :address AND l.postalCode = :postalCode")
    List<Location> findByAddressAndPostalCode(
            @Param("address") String address,
            @Param("postalCode") String postalCode
    );
}
