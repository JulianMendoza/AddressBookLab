package com.addressbook.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuddyInfoRepository extends JpaRepository<BuddyInfo,Long> {
    List<BuddyInfo> name(@Param("name") String name);
}
