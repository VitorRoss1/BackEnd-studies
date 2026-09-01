

/* Tarefa com Prazo (TaskComPrazo)
Crie uma classe TaskComPrazo que herde da classe Task. Ela deverá possuir também:
 prazo e prioridade. A prioridade deverá ser representada por um Enum Prioridade
 (BAIXA, MEDIA, ALTA).*/

public class DatedTask extends Task {
    private String due_date;

    public DatedTask(String subject, String due_date){
        super(subject); //superclass constructorm (init inherited attributes)
        this.due_date = due_date;
        this.set_priority(Priority.MEDIUM); //default priority
    }
    
    //setter
    public void set_due_date(String due_date){this.due_date = due_date;}
    
    //getter
    public String get_due_date(){return this.due_date;}
}
