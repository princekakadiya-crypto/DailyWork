package com.tss.__jpa_app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class PageDto <T>{
    private List<T> content;

    private boolean empty;
    private boolean first;
    private boolean last;
    private long totalElement;
    private int totalPages;
}
