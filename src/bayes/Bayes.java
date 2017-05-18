/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayes;

import data.Email;
import java.util.ArrayList;

/**
 *
 * @author Qosmio
 */
public class Bayes {
    private int spamEmailsCount = 0;
    private int fineEmailsCount = 0;
    private int totalListLength = 0;
    private ArrayList<Word> wordsData = new ArrayList<Word>();
    private ArrayList<String> uniqueWords = new ArrayList<String>();
    private int[] attrV;
    public ArrayList<String> getUniqueWords(ArrayList<Email> list){
        
            String subject;
            for(Email e: list){
                subject = e.getSubject();
            String[] split = subject.split(" ");
            for (String split1 : split) {
                if (!uniqueWords.contains(split1)) {
                    uniqueWords.add(split1);
                }
            }
            
            }
        
        
        return uniqueWords;
    }
    
    
    public void calculateSpamAndFineEmails(ArrayList<Email> list){
        for(Email e: list){
            if(e.getIsSpam()){
                spamEmailsCount++;
            }else{
                fineEmailsCount++;
            }
        }
        totalListLength = list.size();
    }
    
    public int getSpamEmailsCount(){
        return this.spamEmailsCount;
    }
    
    public int getFineEmailsCount(){
        return this.fineEmailsCount;
    }
    
    public ArrayList<Word> setWordsData(ArrayList<Email> list){
        int spamCount=0;
        int fineCount=0;
        for(String s: uniqueWords){
            for(Email e: list){
                if(e.getSubject().contains(s) && e.getIsSpam()){
                    spamCount++;
                }else if(e.getSubject().contains(s) && !e.getIsSpam()){
                    fineCount++;
                }
            }
            wordsData.add(new Word(s,spamCount,this.spamEmailsCount,fineCount,this.fineEmailsCount));
            spamCount = 0;
            fineCount = 0;
            
        }
        return wordsData;
    }
    
    public int[] getAttributeValues(String newEmail){
        attrV = new int[uniqueWords.size()];
        int counter = 0;
        for(String s: uniqueWords){
            if(newEmail.contains(s)){
                attrV[counter] = 1;
            }else{
                attrV[counter] = 0;
            }
            
            counter++;
        }
        
        return attrV;
    }
    
    public float performBayesFormula(){
        float resultS = 1;
        float resultF = 1;
        float finalResult = 0;
        // calcualting for spam
        for(int x=0; x< attrV.length;x++){
            
            if(attrV[x] == 0){
                // add zero frequency error fixture here.
                resultS = resultS * (1-(wordsData.get(x).getSpamCount()/(float)this.spamEmailsCount));
            }else if(attrV[x] == 1){
                // add zero frequency error fixture here.
                resultS = resultS*(wordsData.get(x).getSpamCount()/(float)this.spamEmailsCount);
            }
            
        }
        System.out.println("Result Spam: " + resultS);
        // calcualting for fine
        for(int x=0; x< attrV.length;x++){
            
            if(attrV[x] == 0){
                // add zero frequency error fixture here.
                resultF = resultF*(1-wordsData.get(x).getFineCount()/(float)this.fineEmailsCount);
            }else if(attrV[x] == 1){
                // add zero frequency error fixture here.
                resultF = resultF*(wordsData.get(x).getFineCount()/(float)this.fineEmailsCount);
            }
            
        }
        
             System.out.println("Result Fine: " + resultF);
        
        // apply bayes formula  
        float p1 = (resultF * (this.fineEmailsCount/(float) totalListLength));
        float p2 = (float) ((resultF * (this.fineEmailsCount/(float)totalListLength)) + (resultS * (this.spamEmailsCount/(float)this.totalListLength)));
        finalResult = (float) (p1/p2);
        System.out.println("Probability: " + finalResult);
        return finalResult; 
    }
}
