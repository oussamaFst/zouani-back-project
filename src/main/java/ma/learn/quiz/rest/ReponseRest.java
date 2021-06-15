package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.Reponse;
import ma.learn.quiz.service.ReponseService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "learn/reponse")
public class ReponseRest {
    @GetMapping("/question/id/{id}")
    public List<Reponse> findByQuestionId(@PathVariable Long id) {
        return reponseService.findByQuestionId(id);
    }
    @GetMapping("/ref/{ref}")
    public Reponse findByRef(@PathVariable String ref) {
        return reponseService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")

    public int deleteByRef(@PathVariable String ref) {
        return reponseService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Reponse> findAll() {
        return reponseService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Reponse reponse) {
        return reponseService.save(reponse);
    }

    @Transactional
    @DeleteMapping("/question/ref/{ref}")
    public int deleteByQuestionRef(@PathVariable String ref) {
        return reponseService.deleteByQuestionRef(ref);
    }

    @Autowired
    private ReponseService reponseService;

    @GetMapping("/id/{id}")
    public Optional<Reponse> findById(@PathVariable Long id) {
		return reponseService.findById(id);
	}
	@GetMapping("/etatReponse/{etatReponse}")
	public List<Reponse> findByEtatReponse(@PathVariable String etatReponse) {
		return reponseService.findByEtatReponse(etatReponse);
	}
    
	@GetMapping("/question/numero/{numero}")
	public List<Reponse> findByQuestionNumero(@PathVariable Long numero) {
		return reponseService.findByQuestionNumero(numero);
	}
	
	@GetMapping("/criteria/id/{id}")
	public List<Reponse> findByCriterial(@PathVariable Long id) {
		return reponseService.findByCriterial(id);
	}

}
