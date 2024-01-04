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
    //complex query with 3 parameters
    @Query("SELECT l FROM Location l WHERE l.city = :city AND l.country = :country AND l.postalCode = :postalCode")
    List<Location> findByCityCountryAndPostalCode(
            @Param("city") String city,
            @Param("country") String country,
            @Param("postalCode") String postalCode
    );
    @Query("SELECT l FROM Location l WHERE l.address = :address AND l.postalCode = :postalCode AND l.country = :country")
    List<Location> findByAddressPostalCodeAndCountry(
            @Param("address") String address,
            @Param("postalCode") String postalCode,
            @Param("country") String country
    );
    @Query("SELECT l FROM Location l WHERE l.address = :address AND l.city = :city AND l.country = :country")
    List<Location> findByAddressCityAndCountry(
            @Param("address") String address,
            @Param("city") String city,
            @Param("country") String country
    );

}
