package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.Organization;
import com.whisperlink.whisperlink.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {
}
