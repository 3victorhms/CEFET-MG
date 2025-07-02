package Exercicio38;

public class Aluno {
    private long matricula;
    private Pessoa pessoa;
    private Disciplina[] disciplinas = new Disciplina[10];

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public boolean matricula(Disciplina disciplina) {
        if (disciplina != null) {
            if (disciplina.getCodigo() > 0) {
                if (!verificarMatricula(disciplina.getCodigo())) {
                    for (int i = 0; i < disciplinas.length; i++) {
                        if (disciplinas[i] == null) {
                            disciplinas[i] = disciplina;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean tranca(Disciplina disciplina) {
        if (disciplina != null) {
            if (disciplina.getCodigo() > 0) {
                for (int i = 0; i < disciplinas.length; i++) {
                    if (disciplinas[i].getCodigo() == disciplina.getCodigo()) {
                        disciplinas[i] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean verificarMatricula(long matricula) {
        if (matricula > 0) {
            for (Disciplina disciplina : disciplinas) {
                if (disciplina != null && disciplina.getCodigo() == matricula) {
                    return true;
                }
            }
        }
        return false;
    }
}
