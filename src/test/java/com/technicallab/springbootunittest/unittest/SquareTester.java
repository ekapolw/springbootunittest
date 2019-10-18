package com.technicallab.springbootunittest.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SquareTester {

    @InjectMocks
    private Square square;

    @Mock
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

    }

    @Test
    public void DimensionThreeReturnLengthTwelve(){

    }
}