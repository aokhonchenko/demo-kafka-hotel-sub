package ru.x5.demo.kafka.saga.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x5.demo.kafka.saga.domain.HotelRoom;
import ru.x5.demo.kafka.saga.enums.RoomStatus;
import ru.x5.demo.kafka.saga.exceptions.RoomNotFoundException;
import ru.x5.demo.kafka.saga.repository.HotelRoomRepository;

import java.security.SecureRandom;

@Service
public class HotelRoomService {

    private final HotelRoomRepository hotelRoomRepository;

    public HotelRoomService(HotelRoomRepository hotelRoomRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
    }

    @Transactional
    public Integer getNewRoom(String orderId) {
        // some synthetic errors
        int random = new SecureRandom().nextInt(20);
        if (random == 0) {
            throw new RoomNotFoundException("Не удалось заказать комнату");
        }

        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setOrderId(orderId);
        hotelRoom = hotelRoomRepository.save(hotelRoom);
        return hotelRoom.getId();
    }

    public void declineRoom(String orderId) {
        HotelRoom room = hotelRoomRepository.findByOrderId(orderId);
        room.setStatus(RoomStatus.ERROR);
        hotelRoomRepository.save(room);
    }

    public void approveRoom(String orderId) {
        HotelRoom room = hotelRoomRepository.findByOrderId(orderId);
        room.setStatus(RoomStatus.APPROVED);
        hotelRoomRepository.save(room);
    }
}
