package com.surveyMonkey.controllers;

import com.surveyMonkey.entities.*;
import com.surveyMonkey.repository.SurveyRepository;
import com.surveyMonkey.util.QuestionHelper;
import com.surveyMonkey.util.ResponseHelper;
import com.surveyMonkey.util.SurveyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.surveyMonkey.util.Constants.*;

@Controller
public class AdminController {
    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping({"/"})
    public String home(Model model) {
        return "index";
    }

    @GetMapping({"/surveyTest", "/home"})
    public String createSurvey() {
        return "creation";
    }

    @GetMapping({"/surveyQuestions"})
    public String createQuestions(@RequestParam("title") String title, Model model) {
        model.addAttribute("title", title);
        return "questions";
    }

    @PostMapping("/survey")
    public String listSurvey(@RequestParam("title") String title, Model model) {
        return "questions";
    }

    @GetMapping("/survey/{surveyCode}")
    public String showSurvey(@PathVariable String surveyCode, Model model) {
        Survey survey = new Survey();
        for (Survey s : surveyRepository.findAll()) {
            if (s.getSurveyCode().equals(surveyCode)) {
                survey = s;
            }
        }
        model.addAttribute(survey);
        return "show";
    }

    @GetMapping("/view")
    public String test() {
        return "success";
    }

    @PostMapping({"/surveyResults"})
    public String surveyResult() {
        return "results";
    }

    @ResponseBody
    @PostMapping({"/create"})
    public ResponseHelper createSurvey(@RequestBody SurveyHelper surveyHelper, Model model) {
        Survey survey = new Survey(surveyHelper.getTitle(), surveyHelper.getPassword());
        for (QuestionHelper q : surveyHelper.getQuestions()) {
            switch (q.getQuestionType()) {
                case OPEN_ENDED:
                    survey.setQuestion(new OpenEndedQuestion(q.getQuestion()));
                    break;
                case HISTOGRAM:
                    survey.setQuestion(new HistoQuestion(q.getQuestion(), q.getMinVal(), q.getMaxVal(), q.getStepSize()));
                    break;
                case OPTION:
                    survey.setQuestion(new OptionQuestion(q.getQuestion(), q.getChoices()));
                    break;
            }
        }
        surveyRepository.save(survey);
        model.addAttribute("survey", survey);
        return new ResponseHelper(survey.getSurveyCode(), survey.getTitle());
    }

    @ResponseBody
    @GetMapping("/testQuestions")
    public Survey viewQuestions(@RequestParam("title") String title) {
        for (Survey s : surveyRepository.findAll()) {
            return s;
        }
        return null;
    }

}