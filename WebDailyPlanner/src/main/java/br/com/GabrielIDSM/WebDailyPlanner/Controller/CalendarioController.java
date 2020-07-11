package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.CalendarioLogicalTier;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.CalendarioRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calendario")
public class CalendarioController {
    //Obtem o primero mes de construcao do calendario
    @GetMapping()
    public ResponseEntity<?> getPrimeiroMes(){
        return new ResponseEntity<>(CalendarioLogicalTier.DefinePrimeiroMes(), HttpStatus.OK);
    }
    
    //Obtem o proximo mes ou o anterior do calendario
    @GetMapping(path = "/mes/proximo")
    public ResponseEntity<?> getProximoMes(@RequestBody CalendarioRequestModel rm){
        return new ResponseEntity<>(CalendarioLogicalTier.DefineProximoMes(rm.getMes(), rm.getAno()), HttpStatus.OK);
    }
    
    //Obtem o proximo mes ou o anterior do calendario
    @GetMapping(path = "/mes/anterior")
    public ResponseEntity<?> getMesAnterior(@RequestBody CalendarioRequestModel rm){
        return new ResponseEntity<>(CalendarioLogicalTier.DefineMesAnterior(rm.getMes(), rm.getAno()), HttpStatus.OK);
    }
}
