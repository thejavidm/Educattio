package javiermurillo.educattio.models;

import java.util.Random;

import javiermurillo.educattio.R;

import static javiermurillo.educattio.utils.Constants.DIFICIL;
import static javiermurillo.educattio.utils.Constants.DIVISION;
import static javiermurillo.educattio.utils.Constants.FACIL;
import static javiermurillo.educattio.utils.Constants.MEDIO;
import static javiermurillo.educattio.utils.Constants.MULTIPLICACION;
import static javiermurillo.educattio.utils.Constants.RESTA;
import static javiermurillo.educattio.utils.Constants.SUMA;

public class Problem {
    private String statement;
    private String hint;
    private int result;
    private int answer;
    private boolean correct;
    private boolean answered;
    private int imageId;

    public Problem(String statement, String hint, int result, boolean correct, int imageId) {
        this.statement = statement;
        this.hint = hint;
        this.result = result;
        this.correct = correct;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getHint() {
        return hint;
    }

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

    public void setHint(String hint) {
        this.hint = hint;
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
        String hint = "";
        String operator = "";
        int result = 0;
        int randomNumber1 = randomNumber(5, 10) * (level + 1);
        int randomNumber2 = randomNumber(2, 4) * (level + 1);
        int seed = randomNumber(0, 2);
        int operation;
        int image = R.drawable.default_image;

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
                                image = R.drawable.problema1;
                                break;
                            case 2://2
                                statement = "Tengo " + randomNumber1 + " flores y encuentro " + randomNumber2 + " más. ¿Cuántas tengo en total?";
                                image = R.drawable.problema2;
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
                                image = R.drawable.problema4;
                                break;
                            case 2://5
                                statement = "Ana ha comido " + randomNumber1 + " galletas. si aún le quedan " + randomNumber2 + ", ¿cuántas galletas tenía?";
                                image = R.drawable.problema5_11_13;
                                break;
                        }
                        break;
                    }
                    case DIFICIL: {
                        switch (seed) {
                            case 0://6
                                statement = "En la fiesta hay " + randomNumber1 + " bocadillos de queso y " + randomNumber2 + " de jamón. ¿Cuántos bocadillos hay?";
                                image = R.drawable.problema6;
                                break;
                            case 1://7
                                statement = "Laura colecciona cromos de animales. Tiene " + randomNumber1 + " de loros y " + randomNumber2 + " de perros. ¿Cuántos tiene en total?";
                                image = R.drawable.problema7;
                                break;
                            case 2://8
                                statement = "Tengo una moneda de " + randomNumber1 + " céntimos y otra de " + randomNumber2 + " céntimos. ¿Cuánto dinero tengo en total?";
                                image = R.drawable.problema8;
                                break;
                        }
                        break;
                    }

                }
                result = randomNumber1 + randomNumber2;
                operator = " + ";
                break;
            }
            case RESTA: {
                switch (level) {
                    case FACIL: {
                        switch (seed) {
                            case 0://9
                                statement = "Hay " + randomNumber1 + " peras y me como " + randomNumber2 + ". ¿Cuántas quedan?";
                                image = R.drawable.problema9;
                                break;
                            case 1://10
                                statement = "Hay " + randomNumber1 + " magdalenas y me como " + randomNumber2 + ". ¿Cuántas quedan?";
                                image = R.drawable.problema10;
                                break;
                            case 2://11
                                statement = "Tenía " + randomNumber1 + " galletas. Si me como " + randomNumber2 + ", ¿cuántas me quedan?";
                                image = R.drawable.problema5_11_13;
                                break;
                        }
                        break;
                    }
                    case MEDIO: {
                        switch (seed) {
                            case 0://12
                                statement = "Hay " + randomNumber1 + " manzanas. Si Grin y Kely se comen " + randomNumber2 + ", ¿cuántas quedan?";
                                image = R.drawable.problema12_29;
                                break;
                            case 1://13
                                statement = "Ana tiene " + randomNumber1 + " galletas. Si se come " + randomNumber2 + ", ¿cuántas le quedan?";
                                image = R.drawable.problema5_11_13;
                                break;
                            case 2://14
                                statement = "Tengo " + randomNumber1 + " camisetas. Si " + randomNumber2 + " de ellas son blancas, ¿cuántas son de otros colores?";
                                image = R.drawable.problema14;
                                break;
                        }
                        break;
                    }
                    case DIFICIL: {
                        switch (seed) {
                            case 0://15
                                statement = "Un bus vacío recogió a " + randomNumber1 + " personas. En la primera parada bajaron " + randomNumber2 + ", ¿cuántas personas quedaron?";
                                image = R.drawable.problema15;
                                break;
                            case 1://16
                                statement = "Tengo un puzle de " + randomNumber1 + " piezas. Ya he colocado " + randomNumber2 + ", ¿cuántas me quedan por colocar?";
                                image = R.drawable.problema16;
                                break;
                            case 2://17
                                statement = "Cati necesita " + randomNumber1 + " puntos para pasar al nivel 2 de un juego. Solo tiene " + randomNumber2 + " puntos, ¿cuántos puntos le faltan?";
                                image = R.drawable.problema17;
                                break;
                        }
                        break;
                    }
                }
                result = randomNumber1 - randomNumber2;
                operator = " - ";
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
                                image = R.drawable.problema19;
                                break;

                            case 2://20
                                statement = "Una señora compró " + randomNumber1 + " paquetes con " + randomNumber2 + " sodas cada uno, para llevar a una fiesta, ¿Cuántas sodas llevará a la fiesta?";
                                image = R.drawable.problema20;
                                break;
                        }
                        break;
                    }
                    case MEDIO: {
                        switch (seed) {
                            case 0://21
                                statement = "Dentro de " + randomNumber1 + " semanas tengo vacaciones. ¿Cuántos días tengo que esperar?";
                                randomNumber2 = 7;
                                image = R.drawable.problema21;
                                break;

                            case 1://22
                                statement = "Irene quiere contar las patas de " + randomNumber1 + " abejas. Si cada insecto tiene seis patas, ¿cuántas patas contará en total?";
                                randomNumber2 = 6;
                                image = R.drawable.problema22;
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
                                image = R.drawable.problema24;
                                break;

                            case 1://25
                                statement = "¿Cuál es el resultado de " + randomNumber1 + " x " + randomNumber2 + "?";
                                break;

                            case 2://26
                                statement = "En una granja se recogen " + randomNumber1 + " huevos diariamente, ¿Cuántos huevos se recogerán en total en " + randomNumber2 + " días?";
                                image = R.drawable.problema26;
                                break;
                        }
                        break;
                    }
                }
                result = randomNumber1 * randomNumber2;
                operator = " × ";
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
                                image = R.drawable.problema27;
                                break;

                            case 1://28
                                statement = "Eva quiere leer un cuento de " + randomNumber1 + " páginas en vacaciones. Si estas duran " + randomNumber2 + " semanas, ¿cuántas páginas debe leer cada semana?";
                                image = R.drawable.problema28;
                                break;

                            case 2://29
                                statement = "Cada manzana la hemos partido en " + randomNumber2 + " trozos. Si hay " + randomNumber1 + " trozos, ¿cuántas manzanas he cortado?";
                                image = R.drawable.problema12_29;
                                break;
                        }
                        break;
                    }
                    case MEDIO: {
                        switch (seed) {
                            case 0://30
                                statement = "Quiero poner " + randomNumber1 + " fotos en un álbum. Si el álbum tiene " + randomNumber2 + " páginas y quiero poner en cada página el mismo número de fotos, ¿cuántas podré poner?";
                                image = R.drawable.problema30;
                                break;

                            case 1://31
                                statement = "Hay " + randomNumber1 + " niños en un aula. ¿Cuántos grupos de " + randomNumber2 + " se pueden hacer?";
                                image = R.drawable.problema31;
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
                                image = R.drawable.problema33;
                                break;

                            case 1://34
                                statement = "¿Cuántos billetes de " + randomNumber2 + " € hay como máximo en " + randomNumber1 + " €?";
                                image = R.drawable.problema34;
                                break;

                            case 2://35
                                statement = "En mi patio hay " + randomNumber1 + " árboles. Si un cuarto son pinos, ¿cuántos pinos hay?";
                                randomNumber2 = 4;
                                image = R.drawable.problema35;
                                break;
                        }
                        break;
                    }
                }
                result = randomNumber1 / randomNumber2;
                operator = " ÷ ";
                break;
            }
        }
        hint = "Pista: " + randomNumber1 + operator + randomNumber2 + " = ?";
        return new Problem(statement, hint, result, false, image);
    }

    private int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }
}
