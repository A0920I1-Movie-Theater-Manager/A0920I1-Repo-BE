package com.controller;

import com.model.dto.ShowTimeDTO;
import com.service.impl.ShowtimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
public class ShowtimeController {
    @Autowired
    ShowtimeServiceImpl showtimeService;
    @GetMapping("/showtime-list")
    public ResponseEntity<Page<ShowTimeDTO>> getListShowTime(@PageableDefault(value = 3) Pageable pageable) {
        Page<ShowTimeDTO> showTimeList = this.showtimeService.getAllShowTime(pageable);
        if (showTimeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showTimeList, HttpStatus.OK);
    }
    @GetMapping("/showtime-list/search")
    public ResponseEntity<Page<ShowTimeDTO>> getListSearchByName(@PageableDefault(size = 3) Pageable pageable,
                                                                 @RequestParam String name) {
        Page<ShowTimeDTO> listSearchShowtime = showtimeService.searchByName(name, pageable);
        if (listSearchShowtime.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listSearchShowtime, HttpStatus.OK);
        }
    }
}
