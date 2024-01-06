package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.Organization;
import com.whisperlink.whisperlink.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

//    @Query(value = "SELECT u FROM User u JOIN u.organizations o WHERE o.id = :orgId")
//    List<User> findUsersInOrganization(@Param("orgId") Long orgId);


}
