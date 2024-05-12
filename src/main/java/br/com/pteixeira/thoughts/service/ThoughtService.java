package br.com.pteixeira.thoughts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pteixeira.thoughts.entity.Thought;
import br.com.pteixeira.thoughts.repository.ThoughtRepository;

@Service
public class ThoughtService {
    @Autowired
    ThoughtRepository thoughtRepository;

    public List<Thought> getAll() {
        return thoughtRepository.findAll();
    }

    public Thought getById(Integer id) {
        return thoughtRepository.findById(id).orElse(null);
    }

    public List<Thought> getAllThoughtsByUserId(Integer userId) {
        List<Thought> allThoughts = thoughtRepository.findAll();
        return allThoughts.stream().filter(thought -> thought.getUser().getUserId().equals(userId)).collect(Collectors.toList());
    }

    public List<Thought> getAllThoughtsByUserEmail(String userEmail) {
        List<Thought> allThoughts = thoughtRepository.findAll();
        return allThoughts.stream().filter(thought -> thought.getUser().getUserEmail().equals(userEmail)).collect(Collectors.toList());
    }

    public Thought saveThought(Thought thought){
        return thoughtRepository.save(thought);
    }

    public Thought updateThought(Integer id, Thought newThought) {
        Thought thoughtTarget = thoughtRepository.findById(id).orElse(null);
        
        if(thoughtTarget != null) {
            //Regra de negócio: o único atributo editável de um pensamento é o pensamento em si; não se pode mudar sua autoria.
            thoughtTarget.setThought(newThought.getThought());

            return thoughtRepository.save(thoughtTarget);
        }else {
            return null;
        }
    }

    public Boolean deleteThought(Integer id) {
        Thought thought = thoughtRepository.findById(id).orElse(null);
        if (thought != null) {
            thoughtRepository.delete(thought);
            return true;
        }else{
            return false;
        }
    }

}
