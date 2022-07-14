package com.clerk.clerkb.controller;

import com.clerk.clerkb.dto.SearchDocuments;
import com.clerk.clerkb.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "search", produces = MediaType.APPLICATION_XML_VALUE)
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @GetMapping(value = "/simple/{content}")
    public ResponseEntity<SearchDocuments> simpleSearch(@PathVariable String content){

        return new ResponseEntity<>(searchService.simpleSearch(content), HttpStatus.OK);
    }
}
