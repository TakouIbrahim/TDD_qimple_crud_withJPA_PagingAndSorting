package com.travel.mintp.service;


import com.travel.mintp.model.Region;
import com.travel.mintp.repository.RegionRepository;
import com.travel.mintp.service.impl.RegionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RegionServiceTests {

    @Mock
    RegionRepository regionRepository;

    private RegionServiceImpl classUnderTest;

    @BeforeEach
    public void setUp(){
        classUnderTest = new RegionServiceImpl(regionRepository);
    }

    @Test
    public void itShouldFindByName(){
        //given
        Region region = new Region();
        region.setName("takous");

        //when

        //simuler le comportement attendu du mock
        Mockito.when(regionRepository.findByName(region.getName())).thenReturn(Optional.of(region));

        Optional<Region> result = classUnderTest.findByName(region.getName());

        //then
        Mockito.verify(regionRepository).findByName(region.getName());
        Assertions.assertNotNull(result);
        org.assertj.core.api.Assertions.assertThat(result.get().getName()).isEqualTo("takous");

    }

}
