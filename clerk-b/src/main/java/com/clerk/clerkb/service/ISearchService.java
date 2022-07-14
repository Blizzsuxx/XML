package com.clerk.clerkb.service;

import com.clerk.clerkb.dto.SearchDocuments;

public interface ISearchService {

    SearchDocuments simpleSearch(String content);
}
