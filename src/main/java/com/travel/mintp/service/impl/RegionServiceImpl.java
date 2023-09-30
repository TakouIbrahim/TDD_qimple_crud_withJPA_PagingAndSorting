package com.travel.mintp.service.impl;


import com.travel.mintp.exception.ApiRequestException;
import com.travel.mintp.exception.RegionNotFoundExeption;
import com.travel.mintp.model.Region;
import com.travel.mintp.repository.RegionRepository;
import com.travel.mintp.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public Region saveRegion(Region region) {
        if (findByName(region.getName()).isPresent()){
            throw  new ApiRequestException("la region "+ region.getName()+" existe deja");
        } else {
            return regionRepository.save(region);
        }

    }

    @Override
    public List<Region> listRegion() {

        return (List<Region>) regionRepository.findAll();
    }

    @Override
    public List<Region> listRegionPaging(int pageNumber, int pageSize) {
        Pageable pages =  PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        return regionRepository.findAll(pages).getContent() ;
    }

    @Override
    public Optional<Region> getRegion(Integer id)  {
        Optional<Region> region = regionRepository.findById(id);
        if (region.isPresent()){
            return region;
        }else{

                throw new RegionNotFoundExeption("la region avec l'id "+ id+ " n'existe pas");

        }

            }

    @Override
    public void delete(Integer id) {
        regionRepository.deleteById(id);

    }

    @Override
    public Optional<Region> findByName(String name) {

        return regionRepository.findByName(name);

    }


}
