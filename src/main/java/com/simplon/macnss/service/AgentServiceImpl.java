package com.simplon.macnss.service;


import com.simplon.macnss.model.person.Agent;
import com.simplon.macnss.repository.AgentRepository;
import com.simplon.macnss.security.HashWithSalt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl  {

    @Autowired
    private AgentRepository agentRepository;

    // save agent using agent repository
    public void save(Agent agent) {
        // get the agent passord and hash it
        String password = agent.getPassword();
        agent.setPassword(HashWithSalt.hashPassword(password));
        agentRepository.save(agent);
    }

    public boolean checkAgentEmail(Agent formAgent) {
        Agent agent = agentRepository.findAgentByEmail(formAgent.getEmail());
        return agent != null;
    }

    public boolean checkAgentPassword(Agent formAgent) {
        Agent agent = agentRepository.findAgentByEmail(formAgent.getEmail());
        return HashWithSalt.checkPassword(formAgent.getPassword(), agent.getPassword());
    }

}
