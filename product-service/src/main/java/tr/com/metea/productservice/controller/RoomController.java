package tr.com.metea.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metea.productservice.domain.Room;
import tr.com.metea.productservice.repository.RoomRepository;

import java.util.List;

/**
 * @author Mete Aydin
 * @since 1.06.2022
 */
@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomRepository roomRepository;

    @PostMapping()
    public ResponseEntity<Room> create(@RequestBody Room room) {
        return new ResponseEntity<>(roomRepository.save(room), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
