package tr.com.metea.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.metea.productservice.domain.Room;

/**
 * @author Mete Aydin
 * @since 1.06.2022
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
}
