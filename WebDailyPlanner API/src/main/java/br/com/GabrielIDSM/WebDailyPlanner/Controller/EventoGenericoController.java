package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UsuarioModel;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.EventoGenericoRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UsuarioRepository;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.EventoIdentificacaoRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.IdentificacaoRequestModel;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generico")
public class EventoGenericoController {
    //Repositorio
    final private EventoGenericoRepository EventoRepository;
    final private UsuarioRepository UsuarioRepository;
    
    //Construtor
    @Autowired
    public EventoGenericoController(EventoGenericoRepository EventoRepository, UsuarioRepository Usuariorepository){
        this.EventoRepository = EventoRepository;
        this.UsuarioRepository = Usuariorepository;
    }
    
    //Novo evento
    @PostMapping
    public ResponseEntity<?> Save(@Valid @RequestBody EventoGenericoModel evento){
        EventoRepository.save(evento);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
    
    //Editar evento 
    @PutMapping
    public ResponseEntity<?> Update(@Valid @RequestBody EventoGenericoModel evento){
        EventoRepository.save(evento);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
    
    //Excluir evento
    @PostMapping(path = "/delete")
    public ResponseEntity<?> Delete(@RequestBody EventoIdentificacaoRequestModel identificacao){
        if(!usuarioESenhaExistem(identificacao)) throw new ResourceNotFoundException("Usuario not found by id and senha");
        EventoGenericoModel evento = EventoRepository.findOne(identificacao.getEvento());
        if(evento == null){
            throw new ResourceNotFoundException("Evento not found by id:" + identificacao.getEvento());
        }else{
            EventoRepository.delete(evento);
            return new ResponseEntity<>(evento, HttpStatus.OK);
        }
    }
    
    //Obtem evento por ID
    @PostMapping(path = "/get")
    public ResponseEntity<?> getEventoByID(@RequestBody EventoIdentificacaoRequestModel identificacao){
        if(!usuarioESenhaExistem(identificacao)) throw new ResourceNotFoundException("Usuario not found by id and senha");
        EventoGenericoModel evento = EventoRepository.findOne(identificacao.getEvento());
        if(evento == null) throw new ResourceNotFoundException("Evento not found by id: " + identificacao.getEvento());
        else return new ResponseEntity<>(evento, HttpStatus.OK);
    }
    
    private boolean usuarioESenhaExistem(EventoIdentificacaoRequestModel usuario) {
        try {
            List<UsuarioModel> usuarios = (List<UsuarioModel>) UsuarioRepository.findAll();
            for (UsuarioModel u : usuarios) {
                if (Objects.equals(u.getID(), usuario.getId())
                        && Objects.equals(u.getSenha(), usuario.getSenha())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
