package Exercicio38;

public class Disciplina {
    private long codigo;
    private String nome;
    private String professor;

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty())
            this.nome = nome;
    }

    public void setProfessor(String professor) {
        if (!professor.isEmpty())
            this.professor = professor;
    }
}
