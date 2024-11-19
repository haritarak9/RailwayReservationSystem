package com.ticketbooking;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
 
import com.ticketbooking.book.dao.TrainBookingDao;
import com.ticketbooking.book.entity.TrainBooking;
import com.ticketbooking.book.service.TrainBookingServiceImpl;
 
@ExtendWith(MockitoExtension.class)
public class TicketBookingBookServiceApplicationTests {
 
    @Mock
    private TrainBookingDao trainBookingDao;
 
    @InjectMocks
    private TrainBookingServiceImpl trainBookingService;
 
    @Test
    public void testBookTrain() {
        TrainBooking booking = new TrainBooking();
        booking.setUserId(1);
 
        when(trainBookingDao.save(booking)).thenReturn(booking);
 
        TrainBooking result = trainBookingService.bookTrain(booking);
 
        assertEquals(booking, result);
    }
 
    @Test
    public void testUpdateBooking() {
        TrainBooking booking = new TrainBooking();
        booking.setId(1);
        booking.setUserId(1);
 
        when(trainBookingDao.save(booking)).thenReturn(booking);
 
        TrainBooking result = trainBookingService.updateBooking(booking);
 
        assertEquals(booking, result);
    }
 
    @Test
    public void testGetAllTrainBookings() {
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findAllByOrderByIdDesc()).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getAllTrainBookings();
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByUserId() {
        int userId = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByUserIdOrderByIdDesc(userId)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByUserId(userId);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetTrainBookingById() {
        int id = 1;
        TrainBooking booking = new TrainBooking();
        booking.setId(id);
 
        when(trainBookingDao.findById(id)).thenReturn(Optional.of(booking));
 
        TrainBooking result = trainBookingService.getTrainBookingById(id);
 
        assertEquals(booking, result);
    }
 
    @Test
    public void testGetAllTrainBookingsByStatus() {
        int status = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByStatusOrderByIdDesc(status)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getAllTrainBookingsByStatus(status);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByUserIdandStatus() {
        int userId = 1;
        int status = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByUserIdAndStatusOrderByIdDesc(userId, status)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByUserIdandStatus(userId, status);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByTrainId() {
        int trainId = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByTrainIdOrderByIdDesc(trainId)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByTrainId(trainId);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByTrainIdAndStatus() {
        int trainId = 1;
        int status = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByTrainIdAndStatusOrderByIdDesc(trainId, status)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByTrainIdAndStatus(trainId, status);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByScheduleTrainIdAndStatus() {
        int scheduleTrainId = 1;
        int status = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByScheduleTrainIdAndStatusOrderByIdDesc(scheduleTrainId, status)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByScheduleTrainIdAndStatus(scheduleTrainId, status);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByScheduleTrainId() {
        int scheduleTrainId = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByScheduleTrainId(scheduleTrainId)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByScheduleTrainId(scheduleTrainId);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByBookingTimeBetweenAndUserId() {
        String startDate = "2022-01-01";
        String endDate = "2022-01-31";
        int userId = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByBookingTimeBetweenAndUserIdOrderByIdDesc(startDate, endDate, userId)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByBookingTimeBetweenAndUserId(startDate, endDate, userId);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByBookingTimeBetween() {
        String startDate = "2022-01-01";
        String endDate = "2022-01-31";
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByBookingTimeBetweenOrderByIdDesc(startDate, endDate)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByBookingTimeBetween(startDate, endDate);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByUserIdAndScheduleTrainIdAndTrainSeatIdAndStatus() {
        int userId = 1;
        int scheduleTrainId = 1;
        int trainSeatId = 1;
        int status = 1;
        TrainBooking booking = new TrainBooking();
        booking.setUserId(userId);
        booking.setScheduleTrainId(scheduleTrainId);
        booking.setTrainSeatId(trainSeatId);
        booking.setStatus(status);
 
        when(trainBookingDao.findByUserIdAndScheduleTrainIdAndTrainSeatIdAndStatusOrderByIdDesc(userId, scheduleTrainId, trainSeatId, status)).thenReturn(booking);
 
        TrainBooking result = trainBookingService.getByUserIdAndScheduleTrainIdAndTrainSeatIdAndStatus(userId, scheduleTrainId, trainSeatId, status);
 
        assertEquals(booking, result);
    }
 
    @Test
    public void testGetByStatusNotOrderByIdDesc() {
        int status = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByStatusNotOrderByIdDesc(status)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByStatusNotOrderByIdDesc(status);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByScheduleTrainIdAndStatusNotOrderByIdDesc() {
        int scheduleTrainId = 1;
        int status = 1;
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByScheduleTrainIdAndStatusNotOrderByIdDesc(scheduleTrainId, status)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByScheduleTrainIdAndStatusNotOrderByIdDesc(scheduleTrainId, status);
 
        assertEquals(bookings, result);
    }
 
    @Test
    public void testGetByBookingId() {
        String bookingId = "ABC123";
        List<TrainBooking> bookings = new ArrayList<>();
 
        when(trainBookingDao.findByBookingId(bookingId)).thenReturn(bookings);
 
        List<TrainBooking> result = trainBookingService.getByBookingId(bookingId);
 
        assertEquals(bookings, result);
    }
 
}
