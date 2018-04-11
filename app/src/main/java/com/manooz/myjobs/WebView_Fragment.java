package com.manooz.myjobs;

/**
 * Created by MaNoOoz on 11/26/2017.
 */

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.manooz.jobs_search_engine_material.R;

import static android.content.ContentValues.TAG;


public class WebView_Fragment extends android.support.v4.app.Fragment {

    private Communicator communicator;
    final WebView_Fragment context = this;
    private EditText mUrl;
    public ClipboardManager clipboard;

    int progressStatusCounter = 0;

//    public EditText getmUrl() {
//        return mUrl;
//    }

    private LinksAdapter linksAdapter2;
    private Bundle wBundle;
    private String saveurl;
    private String copiedUrl;
    private ProgressBar pr;
    private FloatingActionButton fab;
    private WebView w;
    private Button lin, lin2, lin3, lin4, lin5, lin6, lin7, back, forword, refresh,go;
    private Bundle webViewBundle;
    private Handler progressHandler = new Handler();
    RelativeLayout mycontainer;

//    private boolean viewGroupIsVisible = true;
//    private View mViewGroup;
//    private Button hideButton;

    public WebView_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.webviewfragment, container, false);
        setHasOptionsMenu(true);
        mycontainer = (RelativeLayout) getActivity().findViewById(R.id.container);
        new SharedData(getActivity());

//        InputMethodManager inputManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//        IBinder binder = v.getWindowToken();
//        inputManager.hideSoftInputFromWindow(binder,
//                InputMethodManager.HIDE_NOT_ALWAYS);



        RelativeLayout ll = (RelativeLayout) inflater.inflate(R.layout.webviewfragment, container, false);

        w = (WebView) ll.findViewById(R.id.wv1);
        w.setWebViewClient(new WebViewClient());
// this code + one in the onPause method for save state(dont lose Data ) for webview +

        if (webViewBundle == null) {
            Log.e("WebView", "Is Null For Now");
        }
        if (webViewBundle != null) {
            Log.e("WebView", "Is Not!!! Null For Now");

            w.restoreState(webViewBundle);
        } else {
            loadWebsite();
        }
        return ll;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        webViewBundle = new Bundle();
        w.saveState(webViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pr = view.findViewById(R.id.progressBar);
        pr.setMax(100);
        pr.setVisibility(View.VISIBLE);
        mUrl = view.findViewById(R.id.editText);
        lin =  view.findViewById(R.id.linkedin);
        lin2 = view.findViewById(R.id.bayt);
        lin3 = view.findViewById(R.id.indeed);
        lin4 = view.findViewById(R.id.glassdoor);
        lin5 = view.findViewById(R.id.mihiti);
        lin6 = view.findViewById(R.id.ngulf);
        lin7 = view.findViewById(R.id.google);

        go =      view.findViewById(R.id.go);
        go.setOnEditorActionListener(new DoneOnEditorActionListener());


        back =    view.findViewById(R.id.back);
        forword = view.findViewById(R.id.forword);
        refresh = view.findViewById(R.id.refresh);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w.loadUrl(mUrl.getText().toString());
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w.goBack();
                pr.setVisibility(ProgressBar.VISIBLE);
            }
        });

        forword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w.goForward();
                pr.setVisibility(ProgressBar.VISIBLE);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w.reload();
//                showUrl();
            }
        });

        // ^ WebView
        w = view.findViewById(R.id.wv1);
        saveurl = w.getUrl();

//        w.addJavascriptInterface(new WebAppInterface(getActivity()), "Android");

        w.getSettings().setJavaScriptEnabled(true);

        w.getSettings().setAllowFileAccess(true);
        w.getSettings().setLoadsImagesAutomatically(true);
        w.getSettings().setSupportZoom(true);
        w.saveState(savedInstanceState);
        w.getSettings().setAllowFileAccessFromFileURLs(true);
        w.getSettings().setAllowUniversalAccessFromFileURLs(true);
        w.getSettings().setBuiltInZoomControls(true);
        w.getSettings().setLoadWithOverviewMode(true);
        w.getSettings().setUseWideViewPort(true);
        w.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        w.setBackgroundColor(Color.WHITE);
        w.canGoBackOrForward(1);
        w.onScreenStateChanged(View.SCREEN_STATE_ON); // require lower api
        mUrl.setVisibility(EditText.GONE);

        w.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pr.setProgress(newProgress);
                if (newProgress < 100 && pr.getVisibility() == ProgressBar.GONE) {
                    pr.setVisibility(ProgressBar.VISIBLE);
                }
                if (newProgress == 100) {
                    pr.setVisibility(ProgressBar.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }

        });


        w.setWebViewClient(new WebViewClient(){
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if (URLUtil.isNetworkUrl(url)) {
//                    return false;
//                }
//
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(intent);
//                return true;
//            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.e(TAG, " onPageStarted WebView Loding...");
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                mUrl.setText(w.getUrl());
                super.onPageFinished(view, url);
            }
        });

        final Vibrator vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        lin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                vibe.vibrate(50);
                w.loadUrl("http://www.linkedin.com/jobs");
            }
        });
        lin2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vibe.vibrate(50);
                w.loadUrl("https://www.bayt.com/ar/saudi-arabia/jobs/search/");
            }
        });
        lin3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vibe.vibrate(50);
                w.loadUrl("https://sa.indeed.com/m/?from=homeLogo");
            }
        });
        lin4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vibe.vibrate(50);
                w.loadUrl(" https://www.glassdoor.com/index.htm");
            }
        });

        lin5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vibe.vibrate(50);
                w.loadUrl(" https://www.mihnati.com/");
            }
        });

        lin6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vibe.vibrate(50);
                w.loadUrl(" https://arabic.naukrigulf.com/search-jobs");
            }
        });

        lin7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vibe.vibrate(50);
                w.loadUrl(" https://www.google.com/");
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.activity_main_drawer, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final EditText mUrl = (EditText) getActivity().findViewById(R.id.editText);
        final View mViewGroup = (View) getActivity().findViewById(R.id.butonsView);

        int id = item.getItemId();

        if (id == R.id.show_url_btn) {
            if (item.isChecked()) item.setChecked(false);
            else item.setChecked(true);
            if (mUrl.getVisibility() == EditText.VISIBLE) {
                mUrl.setVisibility(EditText.GONE);
//                item.setIcon(getResources().getDrawable(android.R.drawable.ic_menu_view));

                Toast.makeText(getActivity(), "URl Hidden", Toast.LENGTH_SHORT).show();
                // Its visible
            } else if (mViewGroup.getVisibility() == View.VISIBLE) {
                mUrl.setVisibility(EditText.VISIBLE);
//                item.setIcon(getResources().getDrawable(android.R.drawable.ic_menu_view));
                item.setTitle(getResources().getString(R.string.Hide_Url));
                Toast.makeText(getActivity(), "URl Shown", Toast.LENGTH_SHORT).show();
                // Either gone or invisible
            }
        } else if (id == R.id.show_btns_btn) {
            if (item.isChecked()) item.setChecked(false);
            else item.setChecked(true);
            if (mViewGroup.getVisibility() == View.VISIBLE) {
                mViewGroup.setVisibility(View.GONE);
                item.setIcon(getResources().getDrawable(android.R.drawable.ic_menu_view));
                Toast.makeText(getActivity(), "Icons Hidden", Toast.LENGTH_SHORT).show();
                // Its visible
            } else {
                mViewGroup.setVisibility(View.VISIBLE);
                item.setIcon(getResources().getDrawable(android.R.drawable.ic_menu_view));
                Toast.makeText(getActivity(), "Icons Shown", Toast.LENGTH_SHORT).show();
                // Either gone or invisible
            }
        } else if (id == R.id.share_app) {
            System.out.println("Hi");
            Intent i = new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=manooz.com.finalapp");
            startActivity(Intent.createChooser(i, "Share via "));
            return true;

        }else if (id == R.id.open_in_browser) {
            openInBrowser();
            Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();


        } else if (id == R.id.copy_btn) {
            mUrl.setMaxLines(2);
            ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label for text", w.getUrl().toString());
            clipboard.setPrimaryClip(clip);
            String s = clip.toString();
            Toast.makeText(getActivity(), "Your Link Copied To The Clipboard", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getActivity(), "Link_Object Copied To Clipboard", Toast.LENGTH_SHORT).show();
            Log.d("on Click", "Clicked!!");

            return true;


//            linksAdapter2.firebasePush(new Link_Object(w.getUrl() + " "," " ,""));
//
//                mUrl.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });

        }


        return super.onOptionsItemSelected(item);
    }

    private void openInBrowser() {

        String url = mUrl.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }

    public void showUrl() {
        mUrl.setVisibility(View.VISIBLE);
        mUrl.setText(saveurl);
    }

    private void loadWebsite() {
        w.loadUrl("https://www.google.com/");
    }
    class DoneOnEditorActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
            return false;
        }
    }

}


// Tested Methods ################ Its Oki To Delete it

//    @Override
//    public void onActivityCreated(final Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (savedInstanceState != null)
//            w = (WebView) getView().findViewById(R.id.wv1);
//        w.restoreState(savedInstanceState);


//    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        w.saveState(outState);
//    }

//  |Helpful Methods
//## ## ## ### ### ### ### ### ### ### ## ## ## ### ## ### ### ### ### ## ## ## #
// Not Working
//    private void hideKeyboard() {
//        getActivity();
//        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
//                Context.INPUT_METHOD_SERVICE);
//
//        if (imm != null) {
//            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
//                    InputMethodManager.HIDE_NOT_ALWAYS);
//        }
//    }
//// #######################################################################################
//    Good Way to handle items icon change on onClick :)
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.search){
//            item.setChecked(!item.isChecked());
//            item.setIcon(item.isChecked() ? R.drawable.ic_launcher : R.drawable.search_icon);
//            return true;
//        }
//        return false;
//    }

// #######################################################################################
//   Press Enter To Insert new links method

//        private void savelinks() {
//
//            String getInputDesc = ldet.getText().toString();
//
//            if (listNote.contains(getInputDesc)) {
//                Toast.makeText(Write_Note_Fragment.this, "Hi", Toast.LENGTH_SHORT).show();
//
//            } else if (getInputDesc == null || getInputDesc.trim().equals("")) {
//                Toast.makeText(Write_Note_Fragment.this, "wrong empty ", Toast.LENGTH_SHORT).show();
//
//            } else {
//                listNote.firebasePush(getInputDesc);
//                ArrayAdapter<String> addaptedAray = new ArrayAdapter<String>(Write_Note_Fragment.this, android.R.layout.simple_list_item_1, listNote);
//                mylinks.setAdapter(addaptedAray);
//                lnet.setText("");
//            }
//
//        }
