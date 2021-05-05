package ma.learn.quiz.dao;

import ma.learn.quiz.bean.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionCoursDao extends JpaRepository<SessionCours, Long> {
    SessionCours findByNumero(String ref);
    int deleteByNumero(String ref);
}