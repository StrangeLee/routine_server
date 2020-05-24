package com.strange.routine_server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "routine")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "time", length = 10, nullable = false)
    private String time; // 값을 넘길때 TimeStamp.valueOf(LocalDateTime.now()) 로 넘기기

    @Column(name = "days", length = 50, nullable = false)
    private String days;

//    @OneToMany(mappedBy = "details")
//    private List<DetailRoutine> detailRoutines = new ArrayList<>();
}
