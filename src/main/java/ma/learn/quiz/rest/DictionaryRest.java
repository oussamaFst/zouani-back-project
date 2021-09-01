package ma.learn.quiz.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.Dictionary;
import ma.learn.quiz.service.DictionaryService;

@RestController
@RequestMapping("learn/dictionary")
public class DictionaryRest {
	@Autowired
	private DictionaryService dictionaryService;
	@GetMapping("/word/{word}")
	public Dictionary findByWord(@PathVariable String word) {
		return dictionaryService.findByWord(word);
	}
	@GetMapping("/id/{id}")
	public Dictionary findDictionaryById(@PathVariable Long id) {
		return dictionaryService.findDictionaryById(id);
	}
	@GetMapping("/word/{word}/Etudiant/id/{id}")
	public Dictionary findByWordAndEtudiantId(@PathVariable String word,@PathVariable Long id) {
		return dictionaryService.findByWordAndEtudiantId(word, id);
	}
	@GetMapping("/etudiant/id/{id}")
	public List<Dictionary> findByEtudiantId(@PathVariable Long id) {
		return dictionaryService.findByEtudiantId(id);
	}
    @DeleteMapping("/words/{word}/Etudiant/id/{id}")
	public int deleteByWordAndEtudiantId(@PathVariable String word,@PathVariable Long id) {
		return dictionaryService.deleteByWordAndEtudiantId(word, id);
	}

	@PutMapping("/")
	public int update(@RequestBody Dictionary dictionary) {
		return dictionaryService.update(dictionary);
	}

	@GetMapping("/")
	public List<Dictionary> findAll() {
		return dictionaryService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody Dictionary dictionary) {
		return dictionaryService.save(dictionary);
	}
	

}