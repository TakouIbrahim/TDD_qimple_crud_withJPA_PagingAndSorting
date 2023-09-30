package com.travel.mintp.repositories;

import com.travel.mintp.model.Region;
import com.travel.mintp.repository.RegionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegionRepositoryTests {

    @Autowired
    private RegionRepository classUnderTest;



    public void setUp(){
        //classUnderTest = new RegionRepository() ;

    }

    @Test
    public void itShouldSaveRegion(){

        //given
        Region region = new Region();
        region.setName("takous");

        //when
        Region result = classUnderTest.save(region);

        //then
        Assertions.assertThat(result.getName()).isEqualTo("takous");
    }

    @Test
    public  void itShouldFindByName(){

        //given
        Region region = new Region();
        region.setName("test region");

        //when
        Region result = classUnderTest.save(region);

        //then
        Assertions.assertThat(classUnderTest.findByName("test region")).isPresent();
    }
}
