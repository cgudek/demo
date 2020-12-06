package com.mavi.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ObjectMappingService extends ObjectMapper {

  public Object mapToObject(String entry, Class<?> objectClass) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    return objectMapper.readValue(entry, objectClass);
  }

}
