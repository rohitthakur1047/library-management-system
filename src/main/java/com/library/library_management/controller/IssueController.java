package com.library.library_management.controller;

import com.library.library_management.entity.IssuedBook;
import com.library.library_management.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/dashboard")
    public Map<String, List<IssuedBook>> getDashboard(@RequestParam Long userId) {
        return issueService.getUserDashboard(userId);
    }


    // 🔹 ISSUE API
    @PostMapping("/issue")
    public String issueBook(@RequestParam Long userId,
                            @RequestParam Long bookId) {
        return issueService.issueBook(userId, bookId);
    }

    // 🔹 RETURN API
    @PostMapping("/return")
    public String returnBook(@RequestParam Long issueId) {
        return issueService.returnBook(issueId);
    }
}