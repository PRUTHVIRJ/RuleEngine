package com.rulemachine.repository;



        import org.springframework.data.jpa.repository.JpaRepository;
        import com.rulemachine.model.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}

