package javiermurillo.educattio.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import javiermurillo.educattio.R;
import javiermurillo.educattio.databinding.ActivitySolveBinding;
import javiermurillo.educattio.models.Problem;

import static javiermurillo.educattio.utils.Constants.EMPTY_STRING;
import static javiermurillo.educattio.utils.Constants.LEVEL;
import static javiermurillo.educattio.utils.Constants.OPERATION;

public class SolveActivity extends AppCompatActivity {

    private final int problemsQuantity = 8;
    ActivitySolveBinding binding;
    private List<Problem> problemList = new ArrayList<>();
    private int level, operationsType;
    private int problemIndex = 0;
    private boolean answered[] = new boolean[problemsQuantity];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initData();
        initBinding();
        initComponents();
        initProblems();
        updateLayout();
    }

    private void initProblems() {
        for (int i = 0; i < problemsQuantity; i++) {
            problemList.add(new Problem().randomProblem(operationsType, level));
        }
    }

    private void updateBooleans() {
        for (int x = 0; x < problemList.size(); x++) {
            answered[x] = problemList.get(x).isAnswered();
        }
    }

    private void initComponents() {
        binding.btnBack.setOnClickListener(v -> {
            problemIndex--;
            if (problemIndex > 0) {
                binding.btnBack.setEnabled(true);
            } else {
                binding.btnBack.setEnabled(false);
            }
            updateLayout();
        });
        binding.btnForward.setOnClickListener(v -> {
            if (problemIndex == problemsQuantity - 1) {
                finishTest();
            } else {
                if (problemIndex == problemsQuantity - 2) {
                    binding.btnForward.setText(getResources().getString(R.string.finalizar));
                }
                problemIndex++;
                binding.btnBack.setEnabled(true);
                updateLayout();
            }
        });
        binding.fab.setOnClickListener(v -> {
            if(!binding.answer.getText().toString().isEmpty()) {
                Problem problem = problemList.get(problemIndex);
                problem.setAnswered(true);
                problem.setAnswer(Integer.parseInt(binding.answer.getText().toString()));
                problem.setCorrect(problem.getAnswer() == problem.getResult());
                updateLayout();
            }else{
                Toast.makeText(this,"Contesta lo que se te pide antes de verificar tu respuesta",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void finishTest() {
        updateBooleans();
        for (boolean s : answered) {
            if (!s) {
                new MaterialDialog.Builder(this)
                        .title("Quedan preguntas sin resolver")
                        .content("¿Está seguro que desea salir?")
                        .positiveText(android.R.string.yes)
                        .negativeText(android.R.string.no)
                        .onPositive((dialog1, which) -> {
                            this.setResult(Activity.RESULT_CANCELED);
                            showStatisticsAndFinish();
                        })
                        .onNegative((dialog1, which) -> {
                            problemIndex--;
                            updateLayout();
                        })
                        .show();
                return;
            }
        }
        showStatisticsAndFinish();
    }

    private void showStatisticsAndFinish() {
        int correctProblems = 0;
        for (Problem problem : problemList) {
            if (problem.isCorrect()) {
                correctProblems++;
            }
        }

        String estadisticas = "Problemas resueltos correctamente: " + correctProblems + " de " + problemsQuantity;
        if (correctProblems == problemsQuantity) {
            estadisticas += "\n¡Felicidades!";
        }

        new MaterialDialog.Builder(this)
                .title("Resultados")
                .content(estadisticas)
                .positiveText(android.R.string.ok)
                .onPositive((dialog, which) -> finish())
                .show();
    }

    @Override
    public void onBackPressed() {
        new MaterialDialog.Builder(this)
                .title("¿Salir?")
                .content("¿Está seguro que desea salir?")
                .positiveText(android.R.string.yes)
                .negativeText(android.R.string.no)
                .onPositive((dialog1, which) -> {
                    this.setResult(Activity.RESULT_CANCELED);
                    super.onBackPressed();
                })
                .show();

    }

    private void updateLayout() {
        setTitle("Problema " + (problemIndex + 1) + " de " + problemsQuantity);
        Problem problem = problemList.get(problemIndex);
        binding.problem.setText(problem.getStatement());
        if (problem.isAnswered()) {
            binding.answer.setText(String.valueOf(problem.getAnswer()));
            binding.answer.setEnabled(false);
            if (problem.isCorrect()) {
                binding.result.setText(getResources().getString(R.string.correcto));
                binding.result.setTextColor(Color.BLUE);
            } else {
                binding.result.setText(getResources().getString(R.string.incorrecto, problem.getResult()));
                binding.result.setTextColor(Color.RED);
            }
        } else {
            binding.answer.setEnabled(true);
            binding.answer.setText(EMPTY_STRING);
            binding.result.setText(getResources().getString(R.string.no_contestada));
            binding.result.setTextColor(Color.BLACK);
        }
    }

    private void initData() {
        Intent i = getIntent();
        level = i.getIntExtra(LEVEL, 0);
        operationsType = i.getIntExtra(OPERATION, 0);
        Log.d("SolveActivity", "Level: " + level);
        Log.d("SolveActivity", "Operation: " + operationsType);
    }

    private void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_solve);
    }
}
