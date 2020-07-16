package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.DiaLogicalTier;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoAniversarioModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UsuarioModel;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.EventoAniversarioRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.EventoGenericoRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UsuarioRepository;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.DiaRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.IdentificacaoRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.DiaResponseModel;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dia")
public class DiaController {
    //Repositorio
    final private EventoGenericoRepository eventoGenericoRepository;
    final private EventoAniversarioRepository eventoAniversarioRepository;
    final private UsuarioRepository UsuarioRepository;
    
    //Construtor
    @Autowired
    public DiaController(EventoGenericoRepository repositoryG, EventoAniversarioRepository repositoryA, UsuarioRepository Usuariorepository){
        this.eventoGenericoRepository = repositoryG;
        this.eventoAniversarioRepository = repositoryA;
        this.UsuarioRepository = Usuariorepository;
    }
    
    //Obtem objeto dia
    @GetMapping()
    public ResponseEntity<?> getDiaByUsuario(@RequestBody DiaRequestModel diaRequest){
        if(!usuarioESenhaExistem(diaRequest)) throw new ResourceNotFoundException("Usuario not found by id and senha");
        List<EventoGenericoModel> eventosGenericos = eventoGenericoRepository.findByUsuario(diaRequest.getUsuario());
        List<EventoAniversarioModel> eventosAniversarios = eventoAniversarioRepository.findByUsuario(diaRequest.getUsuario());
        return new ResponseEntity<>(DiaLogicalTier.DefineResponse(diaRequest.getDia(), eventosGenericos, eventosAniversarios), HttpStatus.OK);
    }
    
    //Obtem todos os eventos registrados pelo usuário
    @PostMapping()
    public ResponseEntity<?> getTodosOsDiasByUsuario(@RequestBody IdentificacaoRequestModel identificacao){
        if(!usuarioESenhaExistem(identificacao)) throw new ResourceNotFoundException("Usuario not found by id and senha");
        List<EventoGenericoModel> eventosGenericos = eventoGenericoRepository.findByUsuario(identificacao.getId());
        List<EventoAniversarioModel> eventosAniversarios = eventoAniversarioRepository.findByUsuario(identificacao.getId());
        DiaResponseModel diaResponse = new DiaResponseModel();
        diaResponse.setEventosGenericos(eventosGenericos);
        diaResponse.setEventosAniversarios(eventosAniversarios);
        return new ResponseEntity<>(diaResponse, HttpStatus.OK);
    }
    
    private boolean usuarioESenhaExistem(DiaRequestModel usuario) {
        try {
            List<UsuarioModel> usuarios = (List<UsuarioModel>) UsuarioRepository.findAll();
            for (UsuarioModel u : usuarios) {
                if (Objects.equals(u.getID(), usuario.getUsuario())
                        && Objects.equals(u.getSenha(), usuario.getSenha())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean usuarioESenhaExistem(IdentificacaoRequestModel usuario) {
        try {
            System.out.println("Usuario.id: " + usuario.getId());
            System.out.println("Usuario.senha: " + usuario.getSenha());
            List<UsuarioModel> usuarios = (List<UsuarioModel>) UsuarioRepository.findAll();
            for (UsuarioModel u : usuarios) {
                System.out.println("u.id: " + u.getID());
                System.out.println("u.senha: " + u.getSenha());
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
