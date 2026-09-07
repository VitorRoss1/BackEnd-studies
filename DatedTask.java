

/* Tarefa com Prazo (TaskComPrazo)
Crie uma classe TaskComPrazo que herde da classe Task. Ela deverá possuir também:
 prazo e prioridade. A prioridade deverá ser representada por um Enum Prioridade
 (BAIXA, MEDIA, ALTA).*/

public class DatedTask extends Task {
    private String due_date;

    public DatedTask(String subject, String due_date){
        super(subject); //superclass constructorm (init inherited attributes)
        this.due_date = due_date;
        this.set_priority(0); //default priority
    }
    
    //setter
    public void set_due_date(String due_date){this.due_date = due_date;}
    
    
    //getter
    public String get_due_date(){return this.due_date;}

        //default string output for the class
    @Override
    public String toString() {
        return "| Subject: " + subject + " | Priority: " + task_Priority + " | Due Date: "+ due_date +"|";
    }

}
