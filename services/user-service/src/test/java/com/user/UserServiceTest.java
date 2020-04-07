package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository UserRepository;

    @Test
    public void getUserTest(){
        User user = mock(User.class);
        long id = 1;
        when(UserRepository.findById(id)).thenReturn(Optional.of(user));
        assertEquals(user, userService.findById(id));
    }

    @Test
    public void getUsersTest(){
        List<User> users = new ArrayList<>();
		User user = mock(User.class);
		users.add(user);
        when(user.getId()).thenReturn(new Long(1));
		when(user.getName()).thenReturn("name");
		when(UserRepository.findAll()).thenReturn(new Iterable<User>() {
			@Override
			public Iterator<User> iterator() {
				return users.iterator();
			}
		});
		List<User> retrievedUsers = userService.getUser();
		assertEquals(retrievedUsers.size(), users.size());
		assertEquals(retrievedUsers.get(0), users.get(0));
    }

    @Test
    public void createUserTest(){
        User user = mock(User.class);

        when(user.getId()).thenReturn(new Long(1));
		when(user.getName()).thenReturn("name");
		when(UserRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.createUser(user));
    }
    @Test
    public void modifUserTest(){
        User user = mock(User.class);
        when(user.getId()).thenReturn((long) 1);
        when(user.getAddress()).thenReturn("user\'s adress");
        when(user.getName()).thenReturn("name");
        when(UserRepository.findById((long) 1)
            .orElseThrow(() -> new RuntimeException("user is not found")))
            .thenReturn(user);
        userService.update(user);
        assertEquals(user, userService.update(user));
    }



    @Test
    public void deleteUserTest(){
        User user = mock(User.class);
        userService.createUser(user);
        verify(UserRepository).save(user);    
    }

}