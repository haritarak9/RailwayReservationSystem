package com.ticketbooking;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.ticketbooking.user.dao.UserDao;
import com.ticketbooking.user.entity.User;
import com.ticketbooking.user.service.UserServiceImpl;
 
public class TicketBookingUserServiceApplicationTests {
 
    @Mock
    private UserDao userDao;
 
    @InjectMocks
    private UserServiceImpl userService;
 
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setEmailId("test@example.com");
        user.setPassword("password");
        user.setRole("ROLE_USER");
 
        when(userDao.save(any(User.class))).thenReturn(user);
 
        User savedUser = userService.registerUser(user);
        assertEquals(user.getEmailId(), savedUser.getEmailId());
    }
 
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1);
        user.setEmailId("test@example.com");
        user.setPassword("password");
        user.setRole("ROLE_USER");
 
        when(userDao.save(any(User.class))).thenReturn(user);
 
        User updatedUser = userService.updateUser(user);
        assertEquals(user.getEmailId(), updatedUser.getEmailId());
    }
 
    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1);
        user.setEmailId("test@example.com");
        user.setPassword("password");
        user.setRole("ROLE_USER");
 
        when(userDao.findById(1)).thenReturn(Optional.of(user));
 
        User foundUser = userService.getUserById(1);
        assertEquals(user.getEmailId(), foundUser.getEmailId());
    }
 
    @Test
    public void testGetUserByEmail() {
        User user = new User();
        user.setEmailId("test@example.com");
        user.setPassword("password");
        user.setRole("ROLE_USER");
 
        when(userDao.findByEmailId("test@example.com")).thenReturn(user);
 
        User foundUser = userService.getUserByEmail("test@example.com");
        assertEquals(user.getEmailId(), foundUser.getEmailId());
    }
 
    @Test
    public void testGetUsersByRoleAndStatus() {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setEmailId("test1@example.com");
        user1.setPassword("password");
        user1.setRole("ROLE_USER");
        userList.add(user1);
 
        User user2 = new User();
        user2.setEmailId("test2@example.com");
        user2.setPassword("password");
        user2.setRole("ROLE_USER");
        userList.add(user2);
 
        when(userDao.findByRoleAndStatus("ROLE_USER", 1)).thenReturn(userList);
 
        List<User> foundUsers = userService.getUsersByRoleAndStatus("ROLE_USER", 1);
        assertEquals(2, foundUsers.size());
    }
    
    @Test
    public void testGetUserByEmailAndPassword() {
        String email = "test@example.com";
        String password = "password";
 
        User user = new User();
        user.setEmailId(email);
        user.setPassword(password);
        user.setRole("ROLE_USER");
 
        when(userDao.findByEmailIdAndPassword(email, password)).thenReturn(user);
 
        User foundUser = userService.getUserByEmailAndPassword(email, password);
        assertEquals(user.getEmailId(), foundUser.getEmailId());
    }
 
    @Test
    public void testGetUserByEmailAndPasswordAndRole() {
        String email = "test@example.com";
        String password = "password";
        String role = "ROLE_USER";
 
        User user = new User();
        user.setEmailId(email);
        user.setPassword(password);
        user.setRole(role);
 
        when(userDao.findByEmailIdAndPasswordAndRole(email, password, role)).thenReturn(user);
 
        User foundUser = userService.getUserByEmailAndPasswordAndRole(email, password, role);
        assertEquals(user.getEmailId(), foundUser.getEmailId());
    }
 
 
}
 