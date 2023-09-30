package com.travel.mintp.controller;

import com.travel.mintp.controller.api.RegionControllerApi;
import com.travel.mintp.model.Region;
import com.travel.mintp.service.RegionService;
import com.travel.mintp.service.impl.ArrondissementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class RegionController implements RegionControllerApi {

    @Autowired
    private RegionService regionService;

    @Override
    public ResponseEntity<Region> saveRegion(Region region) {
        Region regionAdded = regionService.saveRegion(region);
        if(Objects.isNull(regionAdded)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(regionAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<List<Region>> listRegion() {
        return new ResponseEntity<>(regionService.listRegion(), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<List<Region>> listRegionPaging(Integer pageNumber, Integer pageSize) {
        return new ResponseEntity<>(regionService.listRegionPaging(pageNumber, pageSize), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<Optional<Region>> getRegion(Integer id) {
        return new ResponseEntity<>(regionService.getRegion(id), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<String> delete(Integer id) {
        regionService.delete(id);
        return new ResponseEntity<>("Region supprimé avec succes", HttpStatus.OK);
    }


}
