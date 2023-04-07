package by.zmeyka.SecurityAPI.service;

import by.zmeyka.SecurityAPI.model.Person;
import by.zmeyka.SecurityAPI.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    private PeopleRepository peopleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository,PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public void add(Person person){
    person.setPassword(passwordEncoder.encode(person.getPassword()));
    peopleRepository.save(person);
    }
}
