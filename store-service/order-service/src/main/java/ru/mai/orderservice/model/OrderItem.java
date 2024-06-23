package ru.mai.orderservice.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private Long productId;
    private Integer quantity;

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
