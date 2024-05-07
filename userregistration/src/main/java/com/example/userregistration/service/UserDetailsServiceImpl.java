package com.example.userregistration.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.userregistration.model.Users;
import com.example.userregistration.repository.UserJpaRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserJpaRepository userJpaRepository;
    
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    
    	Users user = userJpaRepository.findByEmailId(userName);
    	if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        
    	return new MyUserDetails(user);
    	
    	
    	
    	
    	 /*List<GrantedAuthority> authorities = Arrays.stream(user.getRoles().split(","))
    		        						  .map(role -> new SimpleGrantedAuthority(role.trim()))
    		        						  .collect(Collectors.toList());

        
        // Return UserDetails object
    	 return new org.springframework.security.core.userdetails.User(
    		        user.getEmailId(),
    		        user.getPassword(),
    		        authorities
    		    );*/
    }
}