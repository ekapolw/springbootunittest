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
        assertEquals(4, square.area(2));
    }

    @Test
    public void DimensionThreeReturnAreaNine(){
        when(calculator.multiple(4,4)).thenReturn(16);
        assertEquals(16, square.area(4));
    }

}