package id.indrasudirman.belajarbahasainggris.fragment;

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

public class SimplePastFragment3 extends Fragment {

    private View view;
    private TextView verbalSimplePast, verbalPositifSimplePast, verbalNegatifSimplePast, verbalQuestionSimplePast, nominalSimplePast, nominalPositifSimplePast, timeSignalSimplePast;

    public SimplePastFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past3, container, false);

        verbalSimplePast = view.findViewById(R.id.verbal_simple_past);
        verbalPositifSimplePast = view.findViewById(R.id.verbal_positif_simple_past);
        verbalNegatifSimplePast = view.findViewById(R.id.verbal_negatif_simple_past);
        verbalQuestionSimplePast = view.findViewById(R.id.verbal_question_simple_past);

        nominalSimplePast = view.findViewById(R.id.nominal_simple_past);
        nominalPositifSimplePast = view.findViewById(R.id.nominal_positif_simple_past);

        timeSignalSimplePast = view.findViewById(R.id.time_signal_simple_past);

        SpannableString spannableString = new SpannableString(getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_simple_past));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "Lubna played.\n" +
                        "Lubna did not play.\n" +
                        "Did Lubna play?")
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


        spannableString.setSpan(clickableSpan,9,23,0);
        // make text bold
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbalSimplePast.setMovementMethod(LinkMovementMethod.getInstance());
        verbalSimplePast.setText(spannableString);

        SpannableString spannableString3 = new SpannableString(getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_simple_past));
        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Played adalah bentuk Verb 2 atau bentuk Simple Past yang artinya bermain. Susunan bentuknya adalah Play (Verb 1) - Played (Verb 2) - Played (Verb 3). Play termasuk dalam bentuk Regular Verbs")
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
                alertDialogSimplePast.setMessage("Kata last night adalah contoh dari penggunaan Time signal (bagian bawah halaman ini)")
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

        spannableString3.setSpan(clickableSpan3,67,73,0);
        // make text bold
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), 67, 73, 0);

        spannableString3.setSpan(clickableSpan4,81,91,0);
        // make text bold
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), 81, 91, 0);
        verbalPositifSimplePast.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifSimplePast.setText(spannableString3);

        //Verbal negatif simple past
        SpannableString spannableString4 = new SpannableString(getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_simple_past));
        ClickableSpan clickableSpan5 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Did adalah bentuk Verb 2 atau bentuk Simple Past yang artinya melakukan. Susunan bentuknya adalah Do (Verb 1) - Did (Verb 2) - Did (Verb 3). Did termasuk dalam bentuk Irregular Verbs")
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
                alertDialogSimplePast.setMessage("Kata Not adalah contoh kalimat negatif")
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
                alertDialogSimplePast.setMessage("Kata last night adalah contoh dari penggunaan Time signal (bagian bawah halaman ini)")
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

        spannableString4.setSpan(clickableSpan5,83,86,0);
        // make text bold
        spannableString4.setSpan(new StyleSpan(Typeface.BOLD), 83, 86, 0);

        spannableString4.setSpan(clickableSpan6,87,90,0);
        // make text bold
        spannableString4.setSpan(new StyleSpan(Typeface.BOLD), 87, 90, 0);

        spannableString4.setSpan(clickableSpan7,103,113,0);
        // make text bold
        spannableString4.setSpan(new StyleSpan(Typeface.BOLD), 103, 113, 0);
        verbalNegatifSimplePast.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifSimplePast.setText(spannableString4);

        //Verbal Question Simple Past
        SpannableString spannableString5 = new SpannableString(getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_simple_past));
        ClickableSpan clickableSpan8 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Did adalah bentuk Verb 2 atau bentuk Simple Past yang artinya melakukan. Susunan bentuknya adalah Do (Verb 1) - Did (Verb 2) - Did (Verb 3). Did termasuk dalam bentuk Irregular Verbs")
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
                alertDialogSimplePast.setMessage("Kata Play tidak berubah ke bentuk simple past karena sudah diwaliki pada Did. Begitu juga untuk bentuk negatif sebelumnya")
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
                alertDialogSimplePast.setMessage("Kata last night adalah contoh dari penggunaan Time signal (bagian bawah halaman ini)")
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

        spannableString5.setSpan(clickableSpan8,68,71,0);
        // make text bold
        spannableString5.setSpan(new StyleSpan(Typeface.BOLD), 68, 71, 0);

        spannableString5.setSpan(clickableSpan9,78,82,0);
        // make text bold
        spannableString5.setSpan(new StyleSpan(Typeface.BOLD), 78, 82, 0);

        spannableString5.setSpan(clickableSpan10,90,100,0);
        // make text bold
        spannableString5.setSpan(new StyleSpan(Typeface.BOLD), 90, 100, 0);
        verbalQuestionSimplePast.setMovementMethod(LinkMovementMethod.getInstance());
        verbalQuestionSimplePast.setText(spannableString5);

        //Bentuk Kalimat Nominal
        SpannableString spannableString6 = new SpannableString(getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_simple_past));
        ClickableSpan clickableSpan11 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I was happy.\n" +
                        "I was not happy.\n" +
                        "Was She sick yesterday?")
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


        spannableString6.setSpan(clickableSpan11,9,24,0);
        // make text bold
        spannableString6.setSpan(new StyleSpan(Typeface.BOLD), 9, 24, 0);
        nominalSimplePast.setMovementMethod(LinkMovementMethod.getInstance());
        nominalSimplePast.setText(spannableString6);


        //Bentuk Kalimat Nominal
        SpannableString spannableString7 = new SpannableString(getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_simple_past));
        ClickableSpan clickableSpan12 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Was adalah bentuk Verb 2 atau bentuk Simple Past yang artinya ada (to be). Susunan bentuknya adalah am/are (Verb 1) - was/were (Verb 2) - been (Verb 3). Was termasuk dalam bentuk Irregular Verbs")
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

        ClickableSpan clickableSpan13 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata last week adalah contoh dari penggunaan Time signal (bagian bawah halaman ini)")
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


        spannableString7.setSpan(clickableSpan12,68,71,0);
        // make text bold
        spannableString7.setSpan(new StyleSpan(Typeface.BOLD), 68, 71, 0);

        spannableString7.setSpan(clickableSpan13,102,111,0);
        // make text bold
        spannableString7.setSpan(new StyleSpan(Typeface.BOLD), 102, 111, 0);
        nominalPositifSimplePast.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifSimplePast.setText(spannableString7);

        //Time Signal Header Table

        SpannableString spannableString8 = new SpannableString(getActivity().getResources().getString(R.string.contoh_keterangan_waktu_time_signal));
        ClickableSpan clickableSpan14 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Beberapa penunjuk waktu (time signal) yang biasa digunakan dalam kalimat simple past")
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


        spannableString8.setSpan(clickableSpan14,25,36,0);
        // make text bold
        spannableString8.setSpan(new StyleSpan(Typeface.BOLD), 25,36, 0);
        timeSignalSimplePast.setMovementMethod(LinkMovementMethod.getInstance());
        timeSignalSimplePast.setText(spannableString8);


        return view;
    }
}