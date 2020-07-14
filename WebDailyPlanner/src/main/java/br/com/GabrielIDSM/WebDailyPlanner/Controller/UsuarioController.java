package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.Model.UsuarioModel;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.UsuarioRepository;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.IdentificacaoRequestModel;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    //Repositorio
    final private UsuarioRepository repository;
    
    //Construtor
    @Autowired
    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }
    
    //Criar usuario no Banco de Dados
    @PostMapping
    public ResponseEntity<?> Save(@Valid @RequestBody UsuarioModel usuario){
        repository.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    //Verificar se um usuario existe no Banco de Dados
    @GetMapping(path = "/{ID}")
    public ResponseEntity<?> getUsuarioByID(@PathVariable("ID") Integer ID){
        List<UsuarioModel> usuarios = (List<UsuarioModel>) repository.findAll();
        for(UsuarioModel u: usuarios){
            if(Objects.equals(u.getID(), ID)) return new ResponseEntity<>(u, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //Verificar se um usuario existe no Banco de Dados
    @PostMapping(path = "/login")
    public ResponseEntity<?> getLogin(@Valid @RequestBody IdentificacaoRequestModel usuario){
        if(!usuarioESenhaExistem(usuario)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    private boolean usuarioESenhaExistem(IdentificacaoRequestModel usuario) {
        try {
            List<UsuarioModel> usuarios = (List<UsuarioModel>) repository.findAll();
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
