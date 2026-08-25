
import com.sun.source.tree.NewArrayTree;
import java.util.List;

/*Parte 1 — Requisitos Básicos de POO
Usuário
A classe Usuario deverá possuir os seguintes atributos: id, nome, email, e tarefas (lista de tarefas).

Tarefa com Prazo (TaskComPrazo)
Crie uma classe TaskComPrazo que herde da classe Task. Ela deverá possuir também:
 prazo e prioridade. A prioridade deverá ser representada por um Enum Prioridade
 (BAIXA, MEDIA, ALTA).

Estrutura Sugerida

src/
├── Main.java
├── Usuario.java
├── Task.java
├── TaskComPrazo.java
└── Prioridade.java
Menu do Terminal
O programa deverá possuir um menu simples executado pelo terminal:


=============================
 GERENCIADOR DE TAREFAS
=============================
1 - Cadastrar usuário
2 - Listar usuários
3 - Criar tarefa
4 - Criar tarefa com prazo
5 - Listar tarefas de um usuário
6 - Concluir tarefa
0 - Sair*/
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String email;
    private List<String> tasks; 

//contructor
public User(int id, private String name, String email, List<String> tasks ){
this.id = id;
this.name = name;
this.email = email;
this.tasks = new ArrayList<>(); 

}