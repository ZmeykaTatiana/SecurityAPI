package by.zmeyka.SecurityAPI.service;

import by.zmeyka.SecurityAPI.model.Person;
import by.zmeyka.SecurityAPI.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    private PeopleRepository peopleRepository;
@Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void add(Person person){
    peopleRepository.save(person);
    }
}
