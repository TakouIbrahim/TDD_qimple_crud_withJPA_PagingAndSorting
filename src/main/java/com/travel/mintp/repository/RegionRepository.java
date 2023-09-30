package com.travel.mintp.repository;

import com.travel.mintp.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Integer> {


    Optional<Region> findByName(String name);
}
