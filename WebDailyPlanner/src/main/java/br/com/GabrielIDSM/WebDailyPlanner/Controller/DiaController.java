package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.DiaLogicalTier;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoAniversarioModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.EventoAniversarioRepository;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.EventoGenericoRepository;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.DiaRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.ResponseModel.DiaResponseModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dia")
public class DiaController {
    //Repositorio
    final private EventoGenericoRepository eventoGenericoRepository;
    final private EventoAniversarioRepository eventoAniversarioRepository;
    
    //Construtor
    @Autowired
    public DiaController(EventoGenericoRepository repositoryG, EventoAniversarioRepository repositoryA){
        this.eventoGenericoRepository = repositoryG;
        this.eventoAniversarioRepository = repositoryA;
    }
    
    //Obtem objeto dia
    @GetMapping()
    public ResponseEntity<?> getDiaByUsuario(@RequestBody DiaRequestModel diaRequest){
        List<EventoGenericoModel> eventosGenericos = eventoGenericoRepository.findByUsuario(diaRequest.getUsuario());
        List<EventoAniversarioModel> eventosAniversarios = eventoAniversarioRepository.findByUsuario(diaRequest.getUsuario());
        return new ResponseEntity<>(DiaLogicalTier.DefineResponse(diaRequest.getDia(), eventosGenericos, eventosAniversarios), HttpStatus.OK);
    }
}
