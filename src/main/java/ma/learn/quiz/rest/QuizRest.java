package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.Quiz;
import ma.learn.quiz.service.QuizService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "centre/quiz")
public class QuizRest {
    @PutMapping("/")
    public void update(@RequestBody Quiz quiz) {
        quizService.update(quiz);
    }

    @Autowired
    private QuizService quizService;
    @GetMapping("/ref/{ref}")
    public Quiz findByRef(@PathVariable String ref) {
        return quizService.findByRef(ref);
    }


    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return quizService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Quiz> findAll() {
        return quizService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Quiz cours) {
        return quizService.save(cours);
    }


}
