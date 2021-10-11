package com.controller;

import com.model.entity.Screen;
import com.repository.ScreenRepository;
import com.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
public class ScreenController {
    @Autowired
    ScreenService screenService;

    //Hiển thị danh sách Screen - TriNH.
    @GetMapping("/listScreen")
    public ResponseEntity<List<Screen>> listAllScreen() {
        List<Screen> orderEquipments = screenService.getAllScreen();
        if (orderEquipments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderEquipments, HttpStatus.OK);
    }

    //Chức năng thêm mới phòng chiếu TriNH
    @PostMapping("/createScreen")
    public ResponseEntity<Screen> createFeedbackTech(@RequestBody Screen screen) {
        screenService.createScreen(screen.getName(),screen.getTotalSeat());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // findId Screen - TriNH
    @GetMapping("/findById/{id}")
    public ResponseEntity<Screen> findById(@PathVariable("id") long id){
        Screen screen= screenService.findById(id);
        return new ResponseEntity<>(screen,HttpStatus.OK);
    }

    //search - TriNH
    @GetMapping("/searchNameScreen")
    public ResponseEntity<List<Screen>> searchNameScreen(@RequestParam(value = "name") String name) {
        List<Screen> screens = screenService.searchName(name);
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

}
