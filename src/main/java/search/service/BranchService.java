package search.service;

import search.DemoApplication;
import search.model.Branch;
import search.repository.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BranchService {
    @Autowired
    BranchRepository repository;
    private static final Logger logger= LoggerFactory.getLogger(DemoApplication.class);



    // Search branches by Name
    public List<Branch> searchByName(String name) {
        return repository.findByName(name);
    }

    // Search branches by Code
    public List<Branch> searchByCode(String code) {
        return repository.findByCode(code);
    }

    // Search branches by City
    public List<Branch> searchByCity(String city) {
        return repository.findByCity(city);
    }

    // Search branches by State
    public List<Branch> searchByState(String state) {
        return repository.findByState(state);
    }


}
