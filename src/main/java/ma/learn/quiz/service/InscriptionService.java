package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Inscription;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.InscriptionDao;





@Service
public class InscriptionService {
	@Autowired
	public InscriptionDao inscriptionDao;
	
	@Autowired
	public ParcoursService parcoursService;
	@Autowired
	public CentreService centreService;
	@Autowired
	public EtudiantService etudiantService;
	
	 public int save(Inscription  inscription ) {
			if(findByNumeroInscription(inscription.getNumeroInscription())!=null) {
				return -1;
			}
			Parcours parcours= parcoursService.findByRef(inscription.getParcours().getRef());
			inscription.setParcours(parcours);
			if(parcours==null) {
				return -3;
			}
			
			
			Etudiant etudiant = etudiantService.findByRef(inscription.getEtudiant().getRef());
			inscription.setEtudiant (etudiant );
			if(etudiant ==null) {
				return -5;
			}
			
			else {
				inscriptionDao.save(inscription);
				return 1;
			}
				
		}
	
	
	
	
	



		public Inscription findByEtudiantRef(String ref) {
			return inscriptionDao.findByEtudiantRef(ref);
		}





	public List<Inscription> findByParcoursRef(String ref) {
		return inscriptionDao.findByParcoursRef(ref);
	}



	@Transactional
	public int deleteByNumeroInscription(String numeroInscription) {
		return inscriptionDao.deleteByNumeroInscription(numeroInscription);
	}
	

	

	
	public Inscription findByNumeroInscription(String numeroInscription) {
		return inscriptionDao.findByNumeroInscription(numeroInscription);
	}



}
