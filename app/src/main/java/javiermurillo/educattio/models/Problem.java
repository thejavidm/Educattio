package javiermurillo.educattio.models;

import java.util.Random;

import static javiermurillo.educattio.utils.Constants.DIFICIL;
import static javiermurillo.educattio.utils.Constants.DIVISION;
import static javiermurillo.educattio.utils.Constants.FACIL;
import static javiermurillo.educattio.utils.Constants.MEDIO;
import static javiermurillo.educattio.utils.Constants.MULTIPLICACION;
import static javiermurillo.educattio.utils.Constants.RESTA;
import static javiermurillo.educattio.utils.Constants.SUMA;

public class Problem {
    private String statement;
    private int result;
    private int answer;
    private boolean correct;
    private boolean answered;

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Problem(String statement, int result, boolean correct) {
        this.statement = statement;
        this.result = result;
        this.correct = correct;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Problem() {
    }

    public Problem randomProblem(int operationGroup, int level) {
        String statement = "";
        int result = 0;
        int randomNumber1 = randomNumber(5, 10) * (level + 1);
        int randomNumber2 = randomNumber(2, 4) * (level + 1);
        int seed = randomNumber(0, 2);
        int operation;

        if (operationGroup == 0) {
            operation = randomNumber(0, 1);
        } else {
            operation = randomNumber(2, 3);
        }

        switch (operation) {
            case SUMA: {
                switch (level) {
                    case FACIL: {
                        switch (seed) {
                            case 0:
                            case 1://1
                                statement = "Tengo " + randomNumber1 + " mariquitas y encuentro " + randomNumber2 + ". ¿Cuántas tengo en total?";
                                break;
                            case 2://2
                                statement = "Tengo " + randomNumber1 + " flores y encuentro " + randomNumber2 + " más. ¿Cuántas tengo en total?";
                                break;
                        }
                        break;
                    }
                    case MEDIO: {
                        switch (seed) {
                            case 0://3
                                statement = "¿Cuánto es " + randomNumber1 + " + " + randomNumber2 + " ?";
                                break;
                            case 1://4
                                statement = "Kely tiene " + randomNumber1 + " coches verdes y " + randomNumber2 + " rojos. ¿Cuántos coches tiene en total?";
                                break;
                            case 2://5
                                statement = "Ana ha comido " + randomNumber1 + " galletas. si aún le quedan " + randomNumber2 + ", ¿cuántas galletas tenía?";
                                break;
                        }
                        break;
                    }
                    case DIFICIL: {
                        switch (seed) {
                            case 0://6
                                statement = "En la fiesta hay " + randomNumber1 + " bocadillos de queso y " + randomNumber2 + " de jamón. ¿Cuántos bocadillos hay?";
                                break;
                            case 1://7
                                statement = "Laura colecciona cromos de animales. Tiene " + randomNumber1 + " de loros y " + randomNumber2 + " de perros. ¿Cuántos tiene en total?";
                                break;
                            case 2://8
                                statement = "Tengo una moneda de " + randomNumber1 + " céntimos y otra de " + randomNumber2 + " céntimos. ¿Cuánto dinero tengo en total?";
                                break;
                        }
                        break;
                    }

                }
                result = randomNumber1 + randomNumber2;
                break;
            }
            case RESTA: {
                switch (level) {
                    case FACIL: {
                        switch (seed) {
                            case 0://9
                                statement = "Hay " + randomNumber1 + " peras y me como " + randomNumber2 + ". ¿Cuántas quedan?";
                                break;
                            case 1://10
                                statement = "Hay " + randomNumber1 + " magdalenas y me como " + randomNumber2 + ". ¿Cuántas quedan?";
                                break;
                            case 2://11
                                statement = "Tenía " + randomNumber1 + " galletas. Si me como " + randomNumber2 + ", ¿cuántas me quedan?";
                                break;
                        }
                        break;
                    }
                    case MEDIO: {
                        switch (seed) {
                            case 0://12
                                statement = "Hay " + randomNumber1 + " manzanas. Si Grin y Kely se comen " + randomNumber2 + ", ¿cuántas quedan?";
                                break;
                            case 1://13
                                statement = "Ana tiene " + randomNumber1 + " galletas. Si se come " + randomNumber2 + ", ¿cuántas le quedan?";
                                break;
                            case 2://14
                                statement = "Tengo " + randomNumber1 + " camisetas. Si " + randomNumber2 + " de ellas son blancas, ¿cuántas son de otros colores?";
                                break;
                        }
                        break;
                    }
                    case DIFICIL: {
                        switch (seed) {
                            case 0://15
                                statement = "Un bus vacío recogió a " + randomNumber1 + " personas. En la primera parada bajaron " + randomNumber2 + ", ¿cuántas personas quedaron?";
                                break;
                            case 1://16
                                statement = "Tengo un puzle de " + randomNumber1 + " piezas. Ya he colocado " + randomNumber2 + ", ¿cuántas me quedan por colocar?";
                                break;
                            case 2://17
                                statement = "Cati necesita " + randomNumber1 + " puntos para pasar al nivel 2 de un juego. Solo tiene " + randomNumber2 + " puntos, ¿cuántos puntos le faltan?";
                                break;
                        }
                        break;
                    }
                }
                result = randomNumber1 - randomNumber2;
                break;
            }
            case MULTIPLICACION: {
                switch (level) {
                    case FACIL: {
                        switch (seed) {
                            case 0://18
                                statement = "¿Cuál es el resultado de " + randomNumber1 + " x " + randomNumber2 + "?";
                                break;

                            case 1://19
                                statement = "Un paquete contiene " + randomNumber1 + " cromos. ¿Cuántos cromos tendré comprando " + randomNumber2 + " paquetes?";
                                break;

                            case 2://20
                                statement = "Una señora compró " + randomNumber1 + " paquetes con " + randomNumber2 + " sodas cada uno, para llevar a una fiesta, ¿Cuántas sodas llevará a la fiesta?";
                                break;
                        }
                        break;
                    }
                    case MEDIO: {
                        switch (seed) {
                            case 0://21
                                statement = "Dentro de " + randomNumber1 + " semanas tengo vacaciones. ¿Cuántos días tengo que esperar?";
                                randomNumber2 = 7;
                                break;

                            case 1://22
                                statement = "Irene quiere contar las patas de " + randomNumber1 + " abejas. Si cada insecto tiene seis patas, ¿cuántas patas contará en total?";
                                randomNumber2 = 6;
                                break;

                            case 2://23
                                statement = "¿Cuál es el triple de " + randomNumber1 + "?";
                                randomNumber2 = 3;
                                break;
                        }
                        break;
                    }
                    case DIFICIL: {
                        switch (seed) {
                            case 0://24
                                statement = "Si un par de deportivas valen " + randomNumber1 + " euros, ¿cuánto valdrán " + randomNumber2 + " pares?";
                                break;

                            case 1://25
                                statement = "¿Cuál es el resultado de " + randomNumber1 + " x " + randomNumber2 + "?";
                                break;

                            case 2://26
                                statement = "En una granja se recogen " + randomNumber1 + " huevos diariamente, ¿Cuántos huevos se recogerán en total en " + randomNumber2 + " días?";
                                break;
                        }
                        break;
                    }
                }
                result = randomNumber1 * randomNumber2;
                break;
            }
            case DIVISION: {
                if (randomNumber2 % 2 != 0) {
                    randomNumber2++;
                }
                randomNumber1 = randomNumber2 * randomNumber(1, 4);
                switch (level) {
                    case FACIL: {
                        switch (seed) {
                            case 0://27
                                statement = "Ana ha contado " + randomNumber1 + " patas de gatos en el parque. ¿Cuántos gatos había allí?";
                                randomNumber2 = 2;
                                break;

                            case 1://28
                                statement = "Eva quiere leer un cuento de " + randomNumber1 + " páginas en vacaciones. Si estas duran " + randomNumber2 + " semanas, ¿cuántas páginas debe leer cada semana?";
                                break;

                            case 2://29
                                statement = "Cada manzana la hemos partido en " + randomNumber2 + " trozos. Si hay " + randomNumber1 + " trozos, ¿cuántas manzanas he cortado?";
                                break;
                        }
                        break;
                    }
                    case MEDIO: {
                        switch (seed) {
                            case 0://30
                                statement = "Quiero poner " + randomNumber1 + " fotos en un álbum. Si el álbum tiene " + randomNumber2 + " páginas y quiero poner en cada página el mismo número de fotos, ¿cuántas podré poner?";
                                break;

                            case 1://31
                                statement = "Hay " + randomNumber1 + " niños en un aula. ¿Cuántos grupos de " + randomNumber2 + " se pueden hacer?";
                                break;

                            case 2://32
                                statement = "La mitad de " + randomNumber1 + " es: ";
                                randomNumber2 = 2;
                                break;
                        }
                        break;
                    }
                    case DIFICIL: {
                        switch (seed) {
                            case 0://33
                                statement = "El teatro del colegio dispone de " + randomNumber1 + " asientos. Si están repartidos de forma equitativa en " + randomNumber2 + " líneas, ¿Cuántos asientos habrá por línea?";
                                break;

                            case 1://34
                                statement = "¿Cuántos billetes de " + randomNumber2 + " € hay como máximo en " + randomNumber1 + " €?";
                                break;

                            case 2://35
                                statement = "En mi patio hay " + randomNumber1 + " árboles. Si un cuarto son pinos, ¿cuántos pinos hay?";
                                randomNumber2 = 4;
                                break;
                        }
                        break;
                    }
                }
                result = randomNumber1 / randomNumber2;
                break;
            }
        }

        return new Problem(statement, result, false);
    }

    private int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }
}
