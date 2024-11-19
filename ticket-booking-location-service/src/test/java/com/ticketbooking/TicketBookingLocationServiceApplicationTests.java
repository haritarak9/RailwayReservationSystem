package com.ticketbooking;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketbooking.location.constants.DatabaseConstants.LocationStatus;
import com.ticketbooking.location.dto.CommonApiResponse;
import com.ticketbooking.location.dto.LocationResponseDto;
import com.ticketbooking.location.entity.Location;
import com.ticketbooking.location.resource.LocationResource;
import com.ticketbooking.location.service.LocationService;
 
@ExtendWith(MockitoExtension.class)
public class TicketBookingLocationServiceApplicationTests {
 
    @Mock
    private LocationService locationService;
 
    @InjectMocks
    private LocationResource locationResource;
 
    private ObjectMapper objectMapper = new ObjectMapper();
 
    @Test
    public void testAddLocation() {
        Location location = new Location();
        location.setName("Test Location");
        location.setDescription("Test Description");
 
        when(locationService.addLocation(location)).thenReturn(location);
 
        ResponseEntity<CommonApiResponse> response = locationResource.addLocation(location);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Location added Successfully", response.getBody().getResponseMessage());
    }
 
    @Test
    public void testGetLocationById() {
        Location location = new Location();
        location.setId(1);
        location.setName("Test Location");
        location.setDescription("Test Description");
 
        when(locationService.getLocationById(1)).thenReturn(location);
 
        ResponseEntity<LocationResponseDto> response = locationResource.getLocationById(1);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Location added Successfully", response.getBody().getResponseMessage());
        assertEquals(1, response.getBody().getLocation().size());
    }
 
    @Test
    public void testGetAllLocation() {
        List<Location> locations = new ArrayList<>();
        Location location1 = new Location();
        location1.setId(1);
        location1.setName("Test Location 1");
        location1.setDescription("Test Description 1");
        locations.add(location1);
 
        Location location2 = new Location();
        location2.setId(2);
        location2.setName("Test Location 2");
        location2.setDescription("Test Description 2");
        locations.add(location2);
 
        when(locationService.getAllActiveLocation(LocationStatus.ACTIVE.value())).thenReturn(locations);
 
        ResponseEntity<LocationResponseDto> response = locationResource.getAllLocation();
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Locations fetched Successfully", response.getBody().getResponseMessage());
        assertEquals(2, response.getBody().getLocation().size());
    }
 
    @Test
    public void testUpdateLocation() {
        Location location = new Location();
        location.setId(1);
        location.setName("Updated Location Name");
        location.setDescription("Updated Description");
 
        when(locationService.getLocationById(1)).thenReturn(location);
        when(locationService.udpateLocation(location)).thenReturn(location);
 
        ResponseEntity<CommonApiResponse> response = locationResource.updateLocation(location);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Location updated Successfully", response.getBody().getResponseMessage());
 
        verify(locationService, times(1)).getLocationById(1);
        verify(locationService, times(1)).udpateLocation(location);
    }
 
    @Test
    public void testDeleteLocationById() {
        int locationId = 1;
        Location location = new Location();
        location.setId(locationId);
        location.setName("Test Location");
        location.setDescription("Test Description");
 
        when(locationService.getLocationById(locationId)).thenReturn(location);
        when(locationService.udpateLocation(location)).thenReturn(location);
 
        ResponseEntity<CommonApiResponse> response = locationResource.deleteLocationById(locationId);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Location Deleted Successfully", response.getBody().getResponseMessage());
    }
 
 
    @Test
    public void testSearchLocationsByName() {
        String locationName = "Test Location";
 
        List<Location> locations = new ArrayList<>();
        Location location = new Location();
        location.setId(1);
        location.setName(locationName);
        location.setDescription("Test Description");
        locations.add(location);
 
        when(locationService.searchLocationsByName(locationName)).thenReturn(locations);
 
        ResponseEntity<LocationResponseDto> response = locationResource.searchLocationsByName(locationName);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(locations, response.getBody().getLocation());
    }}
