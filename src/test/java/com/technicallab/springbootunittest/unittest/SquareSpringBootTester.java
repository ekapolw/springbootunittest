package com.technicallab.springbootunittest.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Square.class, Calculator.class})
public class SquareSpringBootTester {

    @Autowired
    private Square square;

    @MockBean
    private Calculator calculator;

    @Test
    public void DimensionTwoReturnAreaFour(){
        when(calculator.multiple(2,2)).thenReturn(4);
        assertEquals(square.area(2) , 4);
    }

    @Test
    public void DimensionThreeReturnAreaNine(){
        when(calculator.multiple(3,3)).thenReturn(9);
        assertEquals(square.area(3) , 9);
    }

    @Test
    public void DimensionTwoReturnLengthEight(){
        when(calculator.add(2,2)).thenReturn(4);
        assertEquals(square.length(2) , 8);
    }

    @Test
    public void DimensionThreeReturnLengthTwelve(){

    }
}
