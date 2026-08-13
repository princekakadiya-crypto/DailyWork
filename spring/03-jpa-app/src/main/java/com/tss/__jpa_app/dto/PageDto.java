package com.tss.__jpa_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDto <T>{
    private List<T> content;

    private boolean empty;
    private boolean first;
    private boolean last;
    private long totalElement;
    private int totalPages;
}
