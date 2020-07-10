package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.EventoGenericoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generico")
public class EventoGenericoController {
    //Repositorio
    final private EventoGenericoRepository repository;
    
    //Construtor
    @Autowired
    public EventoGenericoController(EventoGenericoRepository repository){
        this.repository = repository;
    }
    
    //Novo evento
    @PostMapping
    public ResponseEntity<?> Save(@Valid @RequestBody EventoGenericoModel evento){
        repository.save(evento);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
    
    //Editar evento 
    @PutMapping
    public ResponseEntity<?> Update(@Valid @RequestBody EventoGenericoModel evento){
        repository.save(evento);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
    
    //Excluir evento
    @DeleteMapping(path = "/{ID}")
    public ResponseEntity<?> Delete(@PathVariable("ID") Integer ID){
        EventoGenericoModel evento = repository.findOne(ID);
        if(evento == null){
            throw new ResourceNotFoundException("Evento not found by id:" + ID);
        }else{
            repository.delete(evento);
            return new ResponseEntity<>(evento, HttpStatus.OK);
        }
    }
    
    //Obtem evento por ID
    @GetMapping(path = "/{ID}")
    public ResponseEntity<?> getEventoByID(@PathVariable("ID") Integer ID){
        EventoGenericoModel evento = repository.findOne(ID);
        if(evento == null) throw new ResourceNotFoundException("Evento not found by id: " + ID);
        else return new ResponseEntity<>(evento, HttpStatus.OK);
    }
}
