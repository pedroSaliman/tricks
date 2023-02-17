package com.utils.fixturesfactory;

import lombok.*;
import strategy.Name;
import uk.co.jemos.podam.common.PodamStrategyValue;
import uk.co.jemos.podam.common.PodamStringValue;

@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
@Data
public class Job {

    @PodamStrategyValue(value = Name.class)
@PodamStringValue(length = 4)
    private String job;
    @PodamStrategyValue(value = Name.class)
    @PodamStringValue(length = 5)
    private String username;

}
