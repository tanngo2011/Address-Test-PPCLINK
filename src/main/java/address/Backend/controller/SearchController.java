package address.Backend.controller;

import address.Backend.entity.Province;
import address.Backend.service.ProvinceService;
import address.Backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
public class SearchController {


    private final SearchService searchService;


    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping("/api/v1/search")
    @ResponseStatus(HttpStatus.OK)
    public Set<String> search(@RequestParam String form) {
        Set<String> stringSet = searchService.search(form);
        return stringSet;
    }
}
