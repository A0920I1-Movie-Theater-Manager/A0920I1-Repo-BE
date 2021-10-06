package com.controller;

import com.model.dto.hue.MovieDTO;
import com.model.dto.hue.MovieImageDTO;
import com.model.dto.hue.ShowTimesDTO;
import com.model.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    ScreenService screenService;

    @Autowired
    MovieImageService movieImageService;

    @Autowired
    ShowtimeService showtimeService;

    @Autowired
    GenreService genreService;

    @Autowired
    AccountService accountService;


    // HueHV, phương thức hiển thị tất cả danh sách phim
//    @GetMapping("/list")
//    public ResponseEntity<List<Movie>> getAllMovie(){
//        List<Movie> list = movieService.getAllMovie();
//        if (list.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        else {
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        }
//    }

    @GetMapping("/list")
    public List<Movie> getAllMovie(){
        return movieService.getAllMovie();
    }

    //HueHV, phương thức tạo mới 1 bộ phim
    @PostMapping(value = "/create-movie")
    public ResponseEntity<?> createMovie(@RequestBody MovieDTO movie){
        if (movie == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            movieService.createMovie(movie.getTitle(), movie.getShowingFrom(), movie.getShowingTo(), movie.getCast(), movie.getDirector(), movie.getReleaseDate(), movie.getRated(),
                    movie.getRunningTime(), movie.getProduction(), movie.getTrailerUrl(),
                    movie.getContent(), movie.isIs3D(), movie.getAccountId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //HueHV, phương thức tìm phim theo mã id
    @GetMapping("/list/{id}")
    public Movie getMovieById(@PathVariable(value = "id") long id){
        return movieService.findMovieById(id);
    }

    //HueHV, phương thức chỉnh sửa 1 bộ phim
    @PatchMapping(value = "/update-movie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable(value = "id") long id, @RequestBody MovieDTO movie){
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            movieService.updateMovie(movie.getTitle(), movie.getShowingFrom(), movie.getShowingTo(), movie.getCast(), movie.getDirector(), movie.getReleaseDate(), movie.getRated(),
                    movie.getRunningTime(), movie.getProduction(), movie.getTrailerUrl(),
                    movie.getContent(), movie.isIs3D(), movie.getAccountId(), id);
            System.out.println("update");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //HueHV, phương thức lấy danh sách phòng chiếu
    @GetMapping("/list-screen")
    public List<Screen> getAllScreen(){
        return screenService.findAll();
    }

    // HueHV, phương thức lấy tất cả ảnh của bộ phim theo id của phim
    @GetMapping("/details/{id}")
    public List<MovieImage> getImageByIdMovie(@PathVariable(value = "id") long id){
       return movieImageService.listImageMovieById(id);
    }

    // HueHV, phương thức thêm ảnh cho 1 bộ phim
    @PostMapping("/add-image-movie")
    public ResponseEntity<?> addImageMovie(@RequestBody MovieImageDTO movieImage){
        if (movieImage == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            movieImageService.addImageByIdMovie(movieImage.getImage_url(), movieImage.getMovie_id());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //HueHV, phương thức thêm giờ chiếu cho 1 bộ phim
    @PostMapping("/add-show-times")
    public ResponseEntity<?> addShowTimes(@RequestBody ShowTimesDTO showtime){
        if (showtime == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            showtimeService.addShowTimes(showtime.getShow_time(), showtime.getShow_day(),showtime.getPrice_id());

            // tìm id của showtime thông qua giờ chiếu và ngày chiếu vừa thêm để nối 2 bảng
            Showtime showTimes = showtimeService.getIdByShowDayAndShowTime(showtime.getShow_day(), showtime.getShow_time());
            System.out.println(showTimes.getId()+" "+ showtime.getMovie_id());
            showtimeService.joinTableMovieAndShowtime(showTimes.getId(), showtime.getMovie_id());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //HueHV, phương thức lấy danh sách account của nhân viên
    @GetMapping("/list-employee")
    public List<Account> getAllAccountByCodeEmployee(){
        return accountService.listAccountByCodeEmployee();
    }

    //HueHV, phương thức thêm lịch chiếu
    @PostMapping("/add-genre")
    public ResponseEntity<?> addGenreToMovie(List<Integer> genre, long movie_id){
        for(int i=0;i<genre.size();i++){
            genreService.addGenreToMovie(genre.get(i), movie_id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
