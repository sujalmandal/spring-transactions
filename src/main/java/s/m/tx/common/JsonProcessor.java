package s.m.tx.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s.m.tx.exception.AppException;

@Component
public class JsonProcessor {

    private final ObjectMapper objectMapper;

    @Autowired
    public JsonProcessor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> T toPOJO(final String json, final Class<T> cls){
        try {
            return this.objectMapper.convertValue(json, cls);
        }
        catch (IllegalArgumentException e){
            throw new AppException(ErrorCode.ERROR_PROCESSING_JSON,e);
        }
    }

    public <T> String fromPOJO(T pojo){
        try {
            return this.objectMapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            throw new AppException(ErrorCode.ERROR_PROCESSING_JSON,e);
        }
    }
}
