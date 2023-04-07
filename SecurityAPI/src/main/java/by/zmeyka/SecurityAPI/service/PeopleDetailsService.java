package by.zmeyka.SecurityAPI.service;

import by.zmeyka.SecurityAPI.model.Person;
import by.zmeyka.SecurityAPI.repository.PeopleRepository;
import by.zmeyka.SecurityAPI.security.PeopleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleDetailsService implements UserDetailsService {
    private PeopleRepository peopleRepository;
     @Autowired
    public PeopleDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person>person=peopleRepository.findByUsername(username);
        if(person.isEmpty()){
            throw new UsernameNotFoundException("no such user name");
        }

        return new PeopleDetails(person.get());
    }
}
