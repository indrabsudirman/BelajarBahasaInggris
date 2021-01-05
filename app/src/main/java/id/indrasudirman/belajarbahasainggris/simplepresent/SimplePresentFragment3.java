package id.indrasudirman.belajarbahasainggris.simplepresent;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import id.indrasudirman.belajarbahasainggris.R;


public class SimplePresentFragment3 extends Fragment {

    private View view;
    private TextView verbalSimplePresent;
    private TextView verbalPositifSimplePresent;
    private TextView verbalNegatifSimplePresent;
    private TextView verbalQuestionSimplePresent;
    private TextView nominalSimplePresent;
    private TextView nominalPositifSimplePresent;
    private TextView nominalNegatifSimplePresent;
    private TextView nominalQuestionSimplePresent;

    public SimplePresentFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_present3, container, false);

        initView();

        mSpannableString();

        return view;
    }

    private void initView() {
        verbalSimplePresent = view.findViewById(R.id.verbalSimplePresent);
        verbalPositifSimplePresent = view.findViewById(R.id.verbalPositifSimplePresent);
        verbalNegatifSimplePresent = view.findViewById(R.id.verbalNegatifSimplePresent);
        verbalQuestionSimplePresent = view.findViewById(R.id.verbalQuestionSimplePresent);
        nominalSimplePresent = view.findViewById(R.id.nominalSimplePresent);
        nominalPositifSimplePresent = view.findViewById(R.id.nominalPositifSimplePresent);
        nominalNegatifSimplePresent = view.findViewById(R.id.nominalNegatifSimplePresent);
        nominalQuestionSimplePresent = view.findViewById(R.id.nominalQuestionSimplePresent);
    }

    private void mSpannableString() {
        SpannableString [] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_simple_present))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_simple_present))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_simple_present))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_simple_present))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_simple_present))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_simple_present))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_simple_present))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_simple_present)))};

        ClickableSpan clickableSpan0 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "Lubna plays.\n" +
                        "Lubna does not play.\n" +
                        "Does Lubna play?")
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
                alertDialogSimplePast.setMessage("Plays atau play artinya bermain. Penambahan 's' karena kata kerja dalam Simple Present Tense " +
                        "Jika He, She, It atau Orang ketiga tunggal dalam contoh ini Lubna. Harus ditambah 's' atau 'es'.")
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
                alertDialogSimplePast.setMessage("Does atau do artinya melakukan. Penambahan 's' karena kata kerja dalam Simple Present Tense " +
                        "Jika He, She, It atau Orang ketiga tunggal dalam contoh ini Lubna. Harus ditambah 's' atau 'es'. Jika sudah ditambahkan Does, maka tidak perlu Play menjadi Plays. Cukup Play saja.")
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

        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Every day adalah contoh penggunakan waktu atau time signal dalam kalimat Simple Present Tense. Every day artinya setiap hari.")
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
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I am happy. (happy, kata sifat)\n" +
                        "I am not happy.\n" +
                        "Is She happy?")
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
                alertDialogSimplePast.setMessage("Dalam kalimat nominal Simple Present Tense, cukup menggunakan to be 'am' tidak perlu ditambahkan 's' atau 'es' pada kata kerjanya.")
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

        // verbalSimplePresent
        spannableString[0].setSpan(clickableSpan0,9,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbalSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalSimplePresent.setText(spannableString[0]);

        // verbalPositifSimplePresent
        spannableString[1].setSpan(clickableSpan1,84,89,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 84, 89, 0);
        verbalPositifSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifSimplePresent.setText(spannableString[1]);

        // verbalNegatifSimplePresent
        spannableString[2].setSpan(clickableSpan2,92,96,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 92, 96, 0);
        verbalNegatifSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifSimplePresent.setText(spannableString[2]);

        // verbalNegatifSimplePresent NOT
        spannableString[2].setSpan(clickableSpan3,97,100,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 97, 100, 0);
        verbalNegatifSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifSimplePresent.setText(spannableString[2]);

        // verbalQuestionSimplePresent
        spannableString[3].setSpan(clickableSpan4,104,115,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 104, 115, 0);
        verbalQuestionSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalQuestionSimplePresent.setText(spannableString[3]);

        // nominalSimplePresent
        spannableString[4].setSpan(clickableSpan5,9,24,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 9, 24, 0);
        nominalSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        nominalSimplePresent.setText(spannableString[4]);

        // nominalPositifSimplePresent
        spannableString[5].setSpan(clickableSpan6,71,73,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 71, 73, 0);
        nominalPositifSimplePresent.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifSimplePresent.setText(spannableString[5]);

    }
}