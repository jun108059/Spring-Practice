package practice.basic.domain.sampleDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PutRequestDto {

    private String name;
    private int age;
    private List<CarDto> carList;

}
