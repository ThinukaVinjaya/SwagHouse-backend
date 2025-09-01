package com.thinuka.SwagHouse_backend.auth.repositories;

import com.thinuka.SwagHouse_backend.auth.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface AuthorityRepository  extends JpaRepository<Authority, Long> {
    Authority findByRoleCode(String user);

}
