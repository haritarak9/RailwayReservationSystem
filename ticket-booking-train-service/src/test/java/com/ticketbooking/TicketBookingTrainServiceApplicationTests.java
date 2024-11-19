package com.ticketbooking;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ticketbooking.train.dao.ScheduleTrainDao;
import com.ticketbooking.train.entity.ScheduleTrain;
import com.ticketbooking.train.service.ScheduleTrainServiceImpl;
 
@ExtendWith(MockitoExtension.class)
public class TicketBookingTrainServiceApplicationTests {
 
    @Mock
    private ScheduleTrainDao scheduleTrainDao;
 
    @InjectMocks
    private ScheduleTrainServiceImpl scheduleTrainService;
 
    @Test
    public void testScheduleTrain() {
        ScheduleTrain train = new ScheduleTrain();
        train.setTrainId(1);
         
        when(scheduleTrainDao.save(train)).thenReturn(train);
 
        ScheduleTrain result = scheduleTrainService.scheduleTrain(train);
 
        assertEquals(train, result);
    }
 
    @Test
    public void testGetByTrainId() {
        int trainId = 1;
        List<ScheduleTrain> trains = new ArrayList<>();
        
 
        when(scheduleTrainDao.findByTrainId(trainId)).thenReturn(trains);
 
        List<ScheduleTrain> result = scheduleTrainService.getByTrainId(trainId);
 
        assertEquals(trains, result);
    }
 
    

    @Test
    void testGetByScheduleTrainId_String() {
        ScheduleTrain expected = new ScheduleTrain();
        expected.setId(1);
        
        when(scheduleTrainDao.findByScheduleTrainId("1")).thenReturn(expected);
        
        ScheduleTrain result = scheduleTrainService.getByScheduleTrainId("1");
        
        verify(scheduleTrainDao).findByScheduleTrainId("1");
        
        assertEquals(expected, result);
    }

    @Test
    void testGetByScheduleTimeBetweenAndStatus() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findByScheduleTimeBetweenAndStatus("startDate", "endDate", 1)).thenReturn(expectedList);
        
        List<ScheduleTrain> resultList = scheduleTrainService.getByScheduleTimeBetweenAndStatus("startDate", "endDate", 1);
        
        verify(scheduleTrainDao).findByScheduleTimeBetweenAndStatus("startDate", "endDate", 1);
        
        assertEquals(expectedList, resultList);
    }

    @Test
    public void testGetByScheduleTimeGreaterThanEqualAndStatus() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findByScheduleTimeGreaterThanEqualAndStatus("startDate", 1)).thenReturn(expectedList);
        
        List<ScheduleTrain> resultList = scheduleTrainService.getByScheduleTimeGreaterThanEqualAndStatus("startDate", 1);
        
        verify(scheduleTrainDao).findByScheduleTimeGreaterThanEqualAndStatus("startDate", 1);
        
        assertEquals(expectedList, resultList);
    }

    @Test
    public void testGetByScheduleTimeGreaterThanEqual() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findByScheduleTimeGreaterThanEqual("startDate")).thenReturn(expectedList);
        
        List<ScheduleTrain> resultList = scheduleTrainService.getByScheduleTimeGreaterThanEqual("startDate");
        
        verify(scheduleTrainDao).findByScheduleTimeGreaterThanEqual("startDate");
        
        assertEquals(expectedList, resultList);
    }

    @Test
    public void testGetAllScheduledTrain() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findAll()).thenReturn(expectedList);
        
        List<ScheduleTrain> resultList = scheduleTrainService.getAllScheduledTrain();
        
        verify(scheduleTrainDao).findAll();
        
        assertEquals(expectedList, resultList);
    }

    @Test
    public void testGetByScheduleTimeGreaterThanEqualAndStatusAndTrainId() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findByScheduleTimeGreaterThanEqualAndStatusAndTrainId("startDate", 1, 1)).thenReturn(expectedList);
        
        List<ScheduleTrain> resultList = scheduleTrainService.getByScheduleTimeGreaterThanEqualAndStatusAndTrainId("startDate", 1, 1);
        
        verify(scheduleTrainDao).findByScheduleTimeGreaterThanEqualAndStatusAndTrainId("startDate", 1, 1);
        
        assertEquals(expectedList, resultList);
    }


    @Test
    public void testGetByScheduleTimeBetweenAndStatusAndTrainId() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findByScheduleTimeBetweenAndStatusAndTrainId("startDate", "endDate", 1, 1)).thenReturn(expectedList);
        
        List<ScheduleTrain> resultList = scheduleTrainService.getByScheduleTimeBetweenAndStatusAndTrainId("startDate", "endDate", 1, 1);
        
        verify(scheduleTrainDao).findByScheduleTimeBetweenAndStatusAndTrainId("startDate", "endDate", 1, 1);
        
        assertEquals(expectedList, resultList);
    }

    @Test
    public void testGetByScheduleTimeGreaterThanEqualAndTrainIdInAndStatus() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findByScheduleTimeGreaterThanEqualAndTrainIdInAndStatus("scheduleTime", List.of(1, 2), 1)).thenReturn(expectedList);
        
        List<ScheduleTrain> resultList = scheduleTrainService.getByScheduleTimeGreaterThanEqualAndTrainIdInAndStatus("scheduleTime", List.of(1, 2), 1);
        
        verify(scheduleTrainDao).findByScheduleTimeGreaterThanEqualAndTrainIdInAndStatus("scheduleTime", List.of(1, 2), 1);
        
        assertEquals(expectedList, resultList);
    }

    @Test
    public void testGetByScheduleTimeBetweenAndStatusAndTrainIdIn() {
        List<ScheduleTrain> expectedList = new ArrayList<>();
        
        when(scheduleTrainDao.findByScheduleTimeBetweenAndStatusAndTrainIdIn("startDate", "endDate", 1, List.of(1, 2))).thenReturn(expectedList);
        
       
        List<ScheduleTrain> resultList = scheduleTrainService.getByScheduleTimeBetweenAndStatusAndTrainIdIn("startDate", "endDate", 1, List.of(1, 2));
        
        verify(scheduleTrainDao).findByScheduleTimeBetweenAndStatusAndTrainIdIn("startDate", "endDate", 1, List.of(1, 2));
        
        assertEquals(expectedList, resultList);
    }



    
}