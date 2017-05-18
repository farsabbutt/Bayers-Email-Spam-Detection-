/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Qosmio
 */
public class Email {
    private String subject;
    private Boolean isSpam;
    
    public Email(String subject, Boolean isSpam){
        this.subject = subject;
        this.isSpam = isSpam;
    }
    
    public String getSubject(){ return this.subject; }
    
    public Boolean getIsSpam(){ return this.isSpam; }
    
}
