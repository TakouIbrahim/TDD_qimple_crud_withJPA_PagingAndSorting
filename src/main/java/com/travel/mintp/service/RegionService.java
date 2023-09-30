package com.travel.mintp.service;

import com.travel.mintp.model.Region;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RegionService {

    Region saveRegion(Region region);

    List<Region> listRegion();

    List<Region> listRegionPaging(int pageNumber, int pageSize);

    Optional<Region> getRegion(Integer id);

    void delete(Integer id);

    Optional<Region> findByName(String name);


}
