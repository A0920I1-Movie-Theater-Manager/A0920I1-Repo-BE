package com.controller;

import com.model.entity.Showtime;
import com.service.ShowtimeService;
import com.model.dto.ShowTimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    //    TuHC - lay danh sach suat chieu theo phim
    @GetMapping(value = "/get-showtime/{id}")
    public ResponseEntity<List<Showtime>> getShowtimeByMovieId(@PathVariable("id") long id) {
        List<Showtime> showtimes = showtimeService.findShowtimeByMovieId(id);
        System.out.println("id phim"+id);
        if (showtimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(showtimes, HttpStatus.OK);
        }
    }

    @GetMapping("/auth/showtime-list")
    public ResponseEntity<Page<ShowTimeDTO>> getListShowTime(@PageableDefault(value = 3) Pageable pageable) {
        Page<ShowTimeDTO> showTimeList = this.showtimeService.getAllShowTime(pageable);
        if (showTimeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showTimeList, HttpStatus.OK);
    }

    @GetMapping("/auth/showtime-list/search")
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
