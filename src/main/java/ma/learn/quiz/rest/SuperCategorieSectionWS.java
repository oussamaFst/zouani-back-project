package ma.learn.quiz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.SuperCategorieSection;
import ma.learn.quiz.service.SuperCategorieSectionService;

@RestController
@RequestMapping("E-learning/superCategorieSection")
public class SuperCategorieSectionWS {
	@Autowired
	private SuperCategorieSectionService superCategorieSectionService;
	@GetMapping("/ref/{ref}")
	public SuperCategorieSection findByRef(@PathVariable String ref) {
		return superCategorieSectionService.findByRef(ref);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return superCategorieSectionService.deleteByRef(ref);
	}
	 @PostMapping("/")
	public int save(@RequestBody SuperCategorieSection superCategorieSection) {
		return superCategorieSectionService.save(superCategorieSection);
	}
	 @GetMapping("/")
	public List<SuperCategorieSection> findAll() {
		return superCategorieSectionService.findAll();
	}
	@PutMapping("/")
	public void update(@RequestBody SuperCategorieSection superCategorieSection) {
		superCategorieSectionService.update(superCategorieSection);
	}
	@DeleteMapping("/entity/{entity}")
	public void deleteAll() {
		superCategorieSectionService.deleteAll();
	}

	
	

}