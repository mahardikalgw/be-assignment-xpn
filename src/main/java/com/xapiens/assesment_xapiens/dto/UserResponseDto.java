package com.xapiens.assesment_xapiens.dto;

import java.util.List;

public class UserResponseDto {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserDto> data;

    // Getters and Setters
    public int getPage() {
        return page;
    }

    public UserResponseDto setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPer_page() {
        return per_page;
    }

    public UserResponseDto setPer_page(int per_page) {
        this.per_page = per_page;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public UserResponseDto setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public UserResponseDto setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
        return this;
    }

    public List<UserDto> getData() {
        return data;
    }

    public UserResponseDto setData(List<UserDto> data) {
        this.data = data;
        return this;
    }
}
