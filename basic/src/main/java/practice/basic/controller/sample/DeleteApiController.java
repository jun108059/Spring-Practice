package practice.basic.controller.sample;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    // http://localhost:9093/api/delete
    @DeleteMapping("/delete/{userId}")
    public String delete(@PathVariable Long userId,
                         @RequestParam String account) {
        System.out.println("userId = " + userId);
        System.out.println("account = " + account);
        return "삭제완료";
    }

}
