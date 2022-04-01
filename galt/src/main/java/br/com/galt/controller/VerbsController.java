package br.com.galt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.galt.entity.Verbs;
import br.com.galt.service.VerbsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("verbs")
public class VerbsController {

	@Autowired
	private VerbsService verbsService;

	@GetMapping("all")
	public Flux<Verbs> getAll(){
		return this.verbsService.getAllVerbs();
	}

	@GetMapping("{verbsId}")
	public Mono<ResponseEntity<Verbs>> getVerbsById(@PathVariable int verbsId){
		return this.verbsService.getVerbsById(verbsId)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Mono<Verbs> createVerbs(@RequestBody Mono<Verbs> verbsMono){
		return verbsMono.flatMap(this.verbsService::createVerbs);
	}

	@PutMapping("{verbsId}")
	public Mono<Verbs> updateVerbs(@PathVariable int verbsId,
			@RequestBody Mono<Verbs> verbsMono){
		return this.verbsService.updateVerbs(verbsId, verbsMono);
	}

	@DeleteMapping("{id}")
	public Mono<Void> deleteVerbs(@PathVariable int id){
		return this.verbsService.deleteVerbs(id);
	}
}
