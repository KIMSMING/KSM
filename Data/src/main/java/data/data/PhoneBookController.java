package data.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pb")
public class PhoneBookController {

    private static Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    @Autowired
    private IPhoneBookService<IPhoneBook> phoneBookService;

    @PostMapping
    public ResponseEntity<IPhoneBook> insertPB(@RequestBody PhoneBookRequest dto){
        try {
            if( dto == null ){
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.insert(dto);
            if ( result == null){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ){
            logger.error(ex.toString());
//            return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<IPhoneBook>> getAll(){
        try {
            List<IPhoneBook> result = this.phoneBookService.getAllList();
            return ResponseEntity.ok(result);
        } catch ( Exception ex ){
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        try {
            if ( id == null ){
                return ResponseEntity.badRequest().build();
            }
            Boolean result = this.phoneBookService.remove(id);
            return ResponseEntity.ok(result);
        } catch ( Exception ex ){
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IPhoneBook> update(@PathVariable Long id, @RequestBody PhoneBookRequest dto){
        try {
            if ( id == null || dto == null){
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.update(id, dto);
            return ResponseEntity.ok(result);
        } catch ( Exception ex ){
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
