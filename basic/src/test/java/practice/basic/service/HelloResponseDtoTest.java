package practice.basic.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.basic.service.dto.HelloResponseDto;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        Assertions.assertEquals(name, dto.getName());
        Assertions.assertEquals(amount, dto.getAmount());
    }
}