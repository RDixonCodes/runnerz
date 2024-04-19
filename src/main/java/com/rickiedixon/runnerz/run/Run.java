package com.rickiedixon.runnerz.run;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location,
        @Version
        Integer version
) {

    public Run {
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
        //writing custom constraint
//        if(title.isEmpty()){
//            throw new IllegalArgumentException("Title can not be blank");
//        }
    }
}
