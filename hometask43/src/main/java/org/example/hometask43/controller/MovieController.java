package org.example.hometask43.controller;

import jakarta.validation.Valid;
import org.example.hometask43.dto.MovieDto;
import org.example.hometask43.dto.PageDto;
import org.example.hometask43.dto.SearchDto;
import org.example.hometask43.service.MovieService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final MessageSource messageSource;

    public MovieController(MovieService movieService, MessageSource messageSource) {
        this.movieService = movieService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public String showMovieForm(Model model) {
        model.addAttribute("movieDto", new MovieDto());
        model.addAttribute("movies", movieService.getMovies());
        return "movies";
    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam String title, Model model) {
        model.addAttribute("movieDto", new MovieDto());
        model.addAttribute("movies", movieService.findMovieByTitle(title));
        return "movies";
    }

    @PostMapping
    public String saveMovie(@Valid @ModelAttribute("movieDto") MovieDto movieDto,
                            BindingResult bindingResult,
                            Model model,
                            RedirectAttributes redirectAttributes,
                            Locale locale) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("movies", movieService.getMovies());
            return "movies";
        }

        movieService.saveMovie(movieDto);
        redirectAttributes.addFlashAttribute("successMessage",
                messageSource.getMessage("movie.save.success", null, locale));
        return "redirect:/movies";
    }

    @PostMapping("/delete")
    public String deleteMovie(@RequestParam UUID id) {
        movieService.deleteMovieById(id);
        return "redirect:/movies";
    }

    @GetMapping("/page")
    public String page(@ModelAttribute PageDto pageDto, Model model) {
        List<MovieDto> result = movieService.findPageable(pageDto);
        model.addAttribute("movieDto", new MovieDto());
        model.addAttribute("pageDto", pageDto);
        model.addAttribute("movies", result);
        return "movies";
    }

    @GetMapping("/specs")
    public String specs(@ModelAttribute SearchDto searchDto, Model model) {
        List<MovieDto> result = movieService.findByFilter(searchDto);
        model.addAttribute("movieDto", new MovieDto());
        model.addAttribute("movies", result);
        return "movies";
    }

}
