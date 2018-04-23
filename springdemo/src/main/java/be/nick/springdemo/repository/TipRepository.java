package be.nick.springdemo.repository;

import be.nick.springdemo.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TipRepository extends JpaRepository<Tip, Long> {
}