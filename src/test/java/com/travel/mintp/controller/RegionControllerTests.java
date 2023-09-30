package com.travel.mintp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.mintp.model.Region;
import com.travel.mintp.repository.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
public class RegionControllerTests {

    @Mock
    RegionRepository regionRepository;

    @InjectMocks
    private RegionController regionController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void itShouldReturnAllRegion() throws Exception {

        //given
        List<Region> listRegions = new ArrayList<>();
        listRegions.add(new Region(21, "Centre1"));
        listRegions.add(new Region(22, "Centre2"));

        //when
        //simuler le comportement du repository pour renvoyer cette liste fictive lorsque findAll() est appelé
        Mockito.when(regionRepository.findAll()).thenReturn(listRegions);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/region/regions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(listRegions.size()));

    }

    @Test
    public void itShouldAddNewRegionAndReturnLocation() throws Exception{
        //given
        Region region = new Region();
        region.setName("Centre14");

        //when
        //simuler le comportement du repository pour retourner une region lorsque save() est appelé
        Mockito.when(regionRepository.save(region)).thenReturn(region);

        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/region/region/save")
                .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"id\": 16, \"name\": \"Centre14\" }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/region/region/save/16"));
    }


    private String objectToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            fail("Failed to convert object to json");
            return null;
        }
    }
}
