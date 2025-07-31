package com.GaleriProject.GaleriProject.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private MessageType messageType;
    private String ofStatic;

    public  String prepareErrorMessage(){
        StringBuilder sb =  new StringBuilder();
        sb.append(this.messageType.toString());
        if(this.ofStatic != null && !this.ofStatic.trim().isEmpty()){
            sb.append( " : " );
            sb.append((this.ofStatic.trim()));
        }
        return sb.toString();
    }
}
