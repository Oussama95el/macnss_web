package com.simplon.macnss.repository;

import com.simplon.macnss.model.person.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findAgentByEmail(String email);

}

