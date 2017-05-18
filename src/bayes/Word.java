/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayes;

/**
 *
 * @author Qosmio
 */
public class Word {
    private String Word;
    private int spamCount;
    private int spamCountOutOf;
    private int fineCount;
    private int fineCountOutOf;
    
    public Word(String Word, int spamCount, int spamCountOutOf, int fineCount, int fineCountOutOf){
        this.Word = Word;
        this.spamCount = spamCount;
        this.spamCountOutOf = spamCountOutOf;
        this.fineCount = fineCount;
        this.fineCountOutOf = fineCountOutOf;
    }
    
    public void setSpamCount(int spamCount){
        this.spamCount = spamCount;
    }
    
    public void setSpamCountOutOf(int outOf){
        this.spamCountOutOf = outOf;
    }
    
    public void setFineCount(int fineCount){
        this.fineCount = fineCount; 
    }
    
    public void setfineCountOutOf(int fineCountOutOf){
        this.fineCountOutOf = fineCountOutOf;
    }
    
    public int getSpamCount(){return this.spamCount; }
    public int getSpamCountOutOf(){return this.spamCountOutOf; }
    public int getFineCount(){return this.fineCount; }
    public int getFineCountOutOf(){return this.fineCountOutOf; }
    
    
    
    
    
    
}
