package usuario.app.assement_fundamentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int correct = 0;
    private int wrong = 0;
    private int question = 0;
    private RadioGroup options;
    private TextView textView;
    private int selectedOption;
    private ImageView imageView;
    private TextView question_title;
    private int resposta = 0;
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        options = findViewById(R.id.options);
        selectedOption = options.getCheckedRadioButtonId();
        imageView = findViewById(R.id.imageView);
        question_title = findViewById(R.id.question);
        button = findViewById(R.id.nextButton);
        button2 = findViewById(R.id.restartButton);


    }

    public void nextQuestion(View view) {

        answerLogic(resposta);
        resposta++;
        question++;
        Questions(question);

    }

    public void Questions(int question) {

        int selectedOption = options.getCheckedRadioButtonId();
        RadioButton option1 = options.findViewById(R.id.option1);
        RadioButton option2 = options.findViewById(R.id.option2);
        RadioButton option3 = options.findViewById(R.id.option3);


        switch(question) {
            case 0:
                switch (selectedOption) {
                    case R.id.option3:
                        correct+=1;
                        break;
                    default:
                            wrong+=1;
                        break;
                }
                options.clearCheck();
                break;

            case 1:
                option1.setText(R.string.question2_option1);
                option2.setText(R.string.question2_option2);
                option3.setText(R.string.question2_option3);
                question_title.setText(R.string.question2);
                imageView.setImageResource(R.drawable.bolsonaro);

                break;

            case 2:
                option1.setText(R.string.question3_option1);
                option2.setText(R.string.question3_option2);
                option3.setText(R.string.question3_option3);
                question_title.setText(R.string.question3);
                imageView.setImageResource(R.drawable.dougras);

            break;
            case 3:

                option1.setText(R.string.question4_option1);
                option2.setText(R.string.question4_option2);
                option3.setText(R.string.question4_option3);
                question_title.setText(R.string.question4);
                imageView.setImageResource(R.drawable.daciolo);

            break;
            case 4:
                option1.setText(R.string.question5_option1);
                option2.setText(R.string.question5_option2);
                option3.setText(R.string.question5_option3);
                question_title.setText(R.string.question5);
                imageView.setImageResource(R.drawable.marina);


                break;

            default:
                break;
        }

        }

    public void answerLogic(int resposta){
        int selectedOption = options.getCheckedRadioButtonId();
        switch(resposta) {
            case 0:
                switch (selectedOption) {
                    case R.id.option3:
                        correct+=1;
                        break;
                    default:

                        wrong+=1;

                        break;
                }
                options.clearCheck();
                break;

            case 1:

                switch (selectedOption) {
                    case R.id.option3:
                        correct+=1;

                        break;
                    default:

                            wrong+=1;

                        break;
                }
                options.clearCheck();
                break;

            case 2:

                switch (selectedOption) {
                    case R.id.option1:
                        correct+=1;

                        break;
                    default:

                        wrong+=1;

                        break;
                }
                options.clearCheck();
                break;
            case 3:
                switch (selectedOption) {
                    case R.id.option2:
                        correct+=1;

                        break;
                    default:

                            wrong+=1;

                        break;
                }
                options.clearCheck();
                break;
            case 4:
                switch (selectedOption) {
                    case R.id.option1:
                        correct+=1;
                        showResult();
                        break;
                    default:

                        wrong+=1;
                        showResult();
                        break;
                }
                options.clearCheck();
                break;

            default:
                break;
        }

    }

    public void showResult() {
        textView = findViewById(R.id.result_textView);
        textView.setVisibility(View.VISIBLE);
        if (correct > wrong) {
            textView.setText("Right answers: " + correct + "| Wrong answers:" + wrong + "\n You won");
        } else {
            textView.setText("Right answers: " + correct + "| Wrong answers:" + wrong + "\n You lost");
        }

        button.setVisibility(View.GONE);
        button2.setVisibility(View.VISIBLE);

    }

    public void restartQuestions(View view) {

        RadioButton option1 = options.findViewById(R.id.option1);
        RadioButton option2 = options.findViewById(R.id.option2);
        RadioButton option3 = options.findViewById(R.id.option3);

        question_title.setText(R.string.question1);
        option1.setText(R.string.question1_option1);
        option2.setText(R.string.question1_option2);
        option3.setText(R.string.question1_option3);
        imageView.setImageResource(R.drawable.download);

        correct = 0;
        wrong = 0;
        resposta = -0;
        question = 0;

        textView.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);
        button2.setVisibility(View.INVISIBLE);
    }
}
