package search.controller;

import search.model.Branch;
import search.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    BranchService service;

    // Search branches by Name
    @GetMapping("/search_name")
    public List<Branch> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    // Search branches by Code
    @GetMapping("/search_code")
    public List<Branch> searchByCode(@RequestParam String code) {
        return service.searchByCode(code);
    }

    // Search branches by City
    @GetMapping("/search_city")
    public List<Branch> searchByCity(@RequestParam String city) {
        return service.searchByCity(city);
    }

    // Search branches by State
    @GetMapping("/search_state")
    public List<Branch> searchByState(@RequestParam String state) {
        return service.searchByState(state);
    }

}
