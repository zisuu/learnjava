package de.philipackermann.java.javafx.uebung002;

public class Todo {
  private String description;
  private String until;
  
  public Todo() {
  }
  
  public Todo(String description, String until) {
    this.description = description;
    this.until = until;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUntil() {
    return this.until;
  }
  public void setUntil(String until) {
    this.until = until;
  } 
}
