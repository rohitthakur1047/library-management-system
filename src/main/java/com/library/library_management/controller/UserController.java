package com.library.library_management.controller;

import com.library.library_management.entity.IssuedBook;
import com.library.library_management.service.IssueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IssueService issueService;

    // ✅ USER DASHBOARD (Issued Books)
    @GetMapping("/{userId}/books")
    public List<IssuedBook> getUserBooks(@PathVariable Long userId) {
        return issueService.getUserBooks(userId);
    }
}