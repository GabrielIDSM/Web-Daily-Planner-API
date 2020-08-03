package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import br.com.GabrielIDSM.WebDailyPlanner.LogicalTier.Calendars;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.CalendaryRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calendary")
public class CalendaryController {

    @GetMapping()
    public ResponseEntity<?> getMonth(){
        return new ResponseEntity<>(Calendars.defineFirstMonth(), HttpStatus.OK);
    }

    @GetMapping(path = "nextmonth")
    public ResponseEntity<?> getNext(@RequestBody CalendaryRequestModel rm){
        return new ResponseEntity<>(Calendars.defineNextMonth(rm.getMonth(), rm.getYear()), HttpStatus.OK);
    }

    @GetMapping(path = "previousmonth")
    public ResponseEntity<?> getPrevious (@RequestBody CalendaryRequestModel rm){
        return new ResponseEntity<>(Calendars.definePreviousMonth(rm.getMonth(), rm.getYear()), HttpStatus.OK);
    }
}
