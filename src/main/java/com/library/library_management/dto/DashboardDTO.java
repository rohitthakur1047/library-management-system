package com.library.library_management.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DashboardDTO {
    private String bookTitle;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean returned;
}