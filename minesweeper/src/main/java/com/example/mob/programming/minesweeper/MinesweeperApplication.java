package com.example.mob.programming.minesweeper;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
public class MinesweeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(MinesweeperApplication.class, args);
    }

    @Controller
    public static class IndexController {
        @GetMapping("/")
        String index() {
            return "index";
        }
    }

    @RestController
    public static class GenerateController {
        private final MinesweeperService minesweeperService;

        public GenerateController(MinesweeperService minesweeperService) {
            this.minesweeperService = minesweeperService;
        }

        @PostMapping(value="/generate")
        public List<List<Integer>> postMethodName(@RequestBody GenerateInput input) {
            return this.minesweeperService.generate(input.height, input.width, input.bombPoints());
        }
    }

    public static record GenerateInput(Integer height, Integer width, List<String> bombs) {
        List<Point> bombPoints() {
            return this.bombs.stream()
                .map(xy -> xy.split(","))
                .map(xy -> new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])))
                .toList();
        }
    }
}
