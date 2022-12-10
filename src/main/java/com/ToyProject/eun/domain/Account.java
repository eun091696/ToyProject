package com.ToyProject.eun.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private int id;
    private String username;
    private String password;
    private int role_id;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
