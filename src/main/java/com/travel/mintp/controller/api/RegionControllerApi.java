package com.travel.mintp.controller.api;

import com.travel.mintp.model.Region;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

 @CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/region")
public interface RegionControllerApi {

    @PostMapping(value = "/region/save", produces = "application/json", consumes = "application/json")
    ResponseEntity<Region> saveRegion(@Valid @RequestBody Region region);

    @GetMapping(value = "/regions", produces = "application/json")
    ResponseEntity<List<Region>> listRegion();

     @GetMapping(value = "/regionPagings", produces = "application/json")
     ResponseEntity<List<Region>> listRegionPaging(@RequestParam Integer pageNumber, @RequestParam Integer pageSize);


     @GetMapping(value = "/region/{id}", produces = "application/json")
    ResponseEntity<Optional<Region>> getRegion(@PathVariable Integer id);

    @DeleteMapping(value = "/region/{id}")
    ResponseEntity<String> delete(@PathVariable("id") Integer id);


}
