package com.java.ro.ptng.ch10;

import org.fest.assertions.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CarSearchTest {

    private CarSearch carSearch;
    private Car notASportCar1;
    private Car notASportCar2;
    private Car sportCar1;
    private Car sportCar2;

    @BeforeMethod
    public void setup() {
        carSearch = new CarSearch();
        notASportCar1 = Mockito.mock(Car.class);
        notASportCar2 = Mockito.mock(Car.class);
        sportCar1 = Mockito.mock(Car.class);
        sportCar2 = Mockito.mock(Car.class);

        Mockito.when(notASportCar1.isSportCar()).thenReturn(false);
        Mockito.when(notASportCar2.isSportCar()).thenReturn(false);
        Mockito.when(sportCar1.isSportCar()).thenReturn(true);
        Mockito.when(sportCar2.isSportCar()).thenReturn(true);
    }

    @Test
    public void shouldReturnCorrectSportCars() {
        // given
        carSearch.addCard(notASportCar1);
        carSearch.addCard(notASportCar2);
        carSearch.addCard(sportCar1);
        carSearch.addCard(sportCar2);

        // when
        List<Car> sportCars = carSearch.findSportCars();

        // then
        Assertions.assertThat(sportCars).containsExactly(sportCar1, sportCar2);
    }

}