package com.example.exception_handling.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.Message;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private MessageType messageType;

    private String ofStatic; // bu değer verilmek zorunda değil, eğer verilmezse null olur

    public String prepareErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(messageType.getMessage());
        if(ofStatic != null && !ofStatic.isEmpty()){
           sb.append(" : ").append(ofStatic);
        }
        return sb.toString();
    }
}
