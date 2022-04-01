package br.com.galt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galt.entity.Verbs;
import br.com.galt.repository.VerbsRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VerbsService {

    @Autowired
    private VerbsRepository repository;

    public Flux<Verbs> getAllVerbs(){
        return this.repository.findAll();
    }

    public Mono<Verbs> getVerbsById(int verbsId){
        return this.repository.findById(verbsId);
    }

    public Mono<Verbs> createVerbs(final Verbs verbs){
        return this.repository.save(verbs);
    }

    public Mono<Verbs> updateVerbs(int verbsId, final Mono<Verbs> verbsMono){
        return this.repository.findById(verbsId)
                .flatMap(p -> verbsMono.map(u -> {
                	
                	 p.setId(u.getId()); 
                	 p.setVerb(u.getVerb());
                	 p.setPast_participle(u.getPast_participle());
                	 p.setPast_tense(u.getPast_tense()); 
                  
                    return p;
                }))
                .flatMap(p -> this.repository.save(p));
    }

    public Mono<Void> deleteVerbs(final int id){
        return this.repository.deleteById(id);
    }

}