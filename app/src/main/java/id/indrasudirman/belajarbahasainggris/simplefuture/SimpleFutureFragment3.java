package id.indrasudirman.belajarbahasainggris.simplefuture;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.indrasudirman.belajarbahasainggris.R;


public class SimpleFutureFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbalSimpleFutureWillShall;
    private AppCompatTextView verbalPositifSimplePresentWillShall;
    private AppCompatTextView verbalNegatifSimplePresentWillShall;
    private AppCompatTextView verbalQuestionSimplePresentWillShall;
    private AppCompatTextView verbalGoingToSimplePresent;
    private AppCompatTextView verbalGoingToPositifSimplePresent;
    private AppCompatTextView verbalGoingToNegatifSimplePresent;
    private AppCompatTextView verbalGoingToQuestionSimplePresent;
    private AppCompatTextView nominalSimpleFuture;
    private AppCompatTextView nominalPositifSimpleFuture;
    private AppCompatTextView nominalNegatifSimpleFuture;
    private AppCompatTextView nominalQuestionSimpleFuture;


    public SimpleFutureFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_future3, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        verbalSimpleFutureWillShall = view.findViewById(R.id.verbalSimpleFutureWillShall);
        verbalPositifSimplePresentWillShall = view.findViewById(R.id.verbalPositifSimplePresentWillShall);
        verbalNegatifSimplePresentWillShall = view.findViewById(R.id.verbalNegatifSimplePresentWillShall);
        verbalQuestionSimplePresentWillShall = view.findViewById(R.id.verbalQuestionSimplePresentWillShall);
        verbalGoingToSimplePresent = view.findViewById(R.id.verbalGoingToSimplePresent);
        verbalGoingToPositifSimplePresent = view.findViewById(R.id.verbalGoingToPositifSimplePresent);
        verbalGoingToNegatifSimplePresent = view.findViewById(R.id.verbalGoingToNegatifSimplePresent);
        verbalGoingToQuestionSimplePresent = view.findViewById(R.id.verbalGoingToQuestionSimplePresent);
        nominalSimpleFuture = view.findViewById(R.id.nominalSimpleFuture);
        nominalPositifSimpleFuture = view.findViewById(R.id.nominalPositifSimpleFuture);
        nominalNegatifSimpleFuture = view.findViewById(R.id.nominalNegatifSimpleFuture);
        nominalQuestionSimpleFuture = view.findViewById(R.id.nominalQuestionSimpleFuture);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_will_shall_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_goingto_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_goingto_positif_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_goingto_negatif_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_goingto_question_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_simple_future)))};


        ClickableSpan clickableSpan0 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I will go.\n" +
                        "I will not go.\n" +
                        "Will I go?\n" +
                        "go adalah kata kerja (verb)")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Will/Shall adalah ciri dari Simple Future Tense, artinya akan")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Will/Shall ciri dari Simple Future Tense.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Next week adalah contoh time signal dalam Simple Future Tense.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Penambahan Not, adalah ciri dari kalimat negatif.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan5 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I am going to go.\n" +
                        "I am not going to go.\n" +
                        "am I going to go?\n" +
                        "go adalah kata kerja (verb)\n" +
                        "going to adalah pengganti will/shall artinya akan")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan6 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Going to digunakan sebagai pengganti will/shall artinya akan")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan7 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I will be happy. (happy, kata sifat)\n" +
                        "I will not be happy.\n" +
                        "Will I be happy?")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan8 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Tomorrow adalah contoh time signal dalam Simple Future Tense.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan9 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Penambahan 'Be' sesuai dengan rumus kalimat nominal simple future di atas.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpan10 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("3 Complement terdiri atas : \n - Adjective (kata sifat)\n - Noun (kata benda)\n - Adverb (kata keterangan)")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        // verbalSimpleFutureWillShall
        spannableString[0].setSpan(clickableSpan0,9,34,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 34, 0);
        verbalSimpleFutureWillShall.setMovementMethod(LinkMovementMethod.getInstance());
        verbalSimpleFutureWillShall.setText(spannableString[0]);

        // verbalPositifSimplePresentWillShall
        spannableString[3].setSpan(clickableSpan1,26,36,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 26, 36, 0);
        verbalPositifSimplePresentWillShall.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifSimplePresentWillShall.setText(spannableString[3]);

        // verbalPositifSimplePresentWillShall Contoh Will
        spannableString[3].setSpan(clickableSpan2,78,82,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 78, 82, 0);
        verbalPositifSimplePresentWillShall.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifSimplePresentWillShall.setText(spannableString[3]);

        // verbalPositifSimplePresentWillShall Time Signal Next week
        spannableString[3].setSpan(clickableSpan3,96,105,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 96,105, 0);
        verbalPositifSimplePresentWillShall.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifSimplePresentWillShall.setText(spannableString[3]);

        // verbalNegatifSimplePresentWillShall
        spannableString[4].setSpan(clickableSpan4,89,92,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 89,92, 0);
        verbalNegatifSimplePresentWillShall.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifSimplePresentWillShall.setText(spannableString[4]);

        // verbalGoingToSimplePresent
        spannableString[1].setSpan(clickableSpan5,9,32,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 9,32, 0);
        verbalGoingToSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalGoingToSimplePresent.setText(spannableString[1]);

        // verbalGoingToPositifSimplePresent
        spannableString[6].setSpan(clickableSpan6,99,107,0);
        // make text bold
        spannableString[6].setSpan(new StyleSpan(Typeface.BOLD), 99,107, 0);
        verbalGoingToPositifSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalGoingToPositifSimplePresent.setText(spannableString[6]);

        // nominalSimpleFuture
        spannableString[2].setSpan(clickableSpan7,9,24,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 9,24, 0);
        nominalSimpleFuture.setMovementMethod(LinkMovementMethod.getInstance());
        nominalSimpleFuture.setText(spannableString[2]);

        //nominalPositifSimpleFuture time signal tomorrow
        spannableString[9].setSpan(clickableSpan8,89,97,0);
        // make text bold
        spannableString[9].setSpan(new StyleSpan(Typeface.BOLD), 89,97, 0);
        nominalPositifSimpleFuture.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifSimpleFuture.setText(spannableString[9]);

        //nominalPositifSimpleFuture time signal tomorrow
        spannableString[9].setSpan(clickableSpan9,80,82,0);
        // make text bold
        spannableString[9].setSpan(new StyleSpan(Typeface.BOLD), 80,82, 0);
        nominalPositifSimpleFuture.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifSimpleFuture.setText(spannableString[9]);

        //nominalNegatifSimpleFuture
        spannableString[10].setSpan(clickableSpan10,53,65,0);
        // make text bold
        spannableString[10].setSpan(new StyleSpan(Typeface.BOLD), 53,65, 0);
        nominalNegatifSimpleFuture.setMovementMethod(LinkMovementMethod.getInstance());
        nominalNegatifSimpleFuture.setText(spannableString[10]);
    }

}