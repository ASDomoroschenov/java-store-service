package ru.mai.orderservice.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Data
@Slf4j
@Builder
@RedisHash("Order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Id
    private Long idUser;
    private List<OrderItem> orderItemList;

    @Override
    public String toString() {
        String json = "";

        try {
            json = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            log.error("Error while parsing object to json");
        }

        return json;
    }

}
