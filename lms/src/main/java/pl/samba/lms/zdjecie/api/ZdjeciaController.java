package pl.samba.lms.zdjecie.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.samba.lms.utils.api.ControllerInterface;
import pl.samba.lms.zdjecie.Zdjecie;
import pl.samba.lms.zdjecie.database.ZdjecieRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/zdjecie", produces = "application/json")
public class ZdjeciaController implements ControllerInterface<Zdjecie, ZdjecieModel> {
    private final ZdjecieRepository dataSet;
    public ZdjeciaController(ZdjecieRepository dataSet){
        this.dataSet = dataSet;
    }
    @GetMapping
    @Override
    public CollectionModel<Object> getAllEndPoints() {
        return null;
    }

    @Override
    public ResponseEntity<CollectionModel<ZdjecieModel>> get(Integer size, Integer page) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ZdjecieModel> get(@PathVariable("id") Integer id) {
        Optional<Zdjecie> optZdjecie = Optional.ofNullable(dataSet.getById(id));
        if(optZdjecie.isPresent()){
            ZdjecieModel um = new ZdjecieModelAssembler().toModel(optZdjecie.get());
            return new ResponseEntity<>(um, HttpStatus.OK);
        }
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public ResponseEntity<Object> post(Zdjecie data) {
        return null;
    }

    @Override
    public Zdjecie put(Zdjecie data) {
        return null;
    }

    @Override
    public Zdjecie patch(Integer id, Zdjecie data) {
        return null;
    }
}
