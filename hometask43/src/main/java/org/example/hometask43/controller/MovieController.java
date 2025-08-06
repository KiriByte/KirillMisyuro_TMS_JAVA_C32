package org.example.hometask43.controller;

import jakarta.validation.Valid;
import org.example.hometask43.dto.MovieDto;
import org.example.hometask43.service.MovieService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String deleteMovie(@RequestParam UUID id,
                              RedirectAttributes redirectAttributes,
                              Locale locale) {
        if (movieService.deleteMovieById(id)) {
            redirectAttributes.addFlashAttribute("successMessage",
                    messageSource.getMessage("movie.delete.success", null, locale));
        } else {
            redirectAttributes.addFlashAttribute("errorMessage",
                    messageSource.getMessage("movie.delete.error", null, locale));
        }
        return "redirect:/movies";
    }
}
