package de.newschool.newschool_lockscreen;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 07.04.2016.
 */
public class SubjectsList {
    final static String LOG_TAG = SubjectsList.class.getName();
    Context mcontext;

    public SubjectsList(Context context){
        mcontext = context;
    }
    public List<SubjectDetail> getAllSubjects(){
        List<String> names = getSubjectsName();

        List<SubjectDetail> subjects = new ArrayList<>();

        if(names != null) {
            for (int i = 0; i < names.size(); i++) {

                SubjectDetail sd = new SubjectDetail();


                // Log.d(LOG_TAG,names.get(i));
                //int string_id = mcontext.getResources().getIdentifier(names.get(i),"string",mcontext.getPackageName());
                sd.name = names.get(i);


                // int imageId = mcontext.getResources().getIdentifier(names.get(i),"drawable",mcontext.getPackageName());
                //   Log.d(LOG_TAG,names.get(i));
                //  Log.d(LOG_TAG,Integer.toString(imageId));

                Log.d(LOG_TAG, sd.name);
                switch (sd.name) {
                    case "Informatik":
                        sd.pic = R.drawable.informatik;
                        break;
                    case "Deutsch":
                        sd.pic = R.drawable.deutsch;
                        break;
                    case "Franzoesisch":
                        sd.pic = R.drawable.franzoesisch;
                        break;
                    case "Latein":
                        sd.pic = R.drawable.latein;
                        break;
                    case "Geschichte":
                        sd.pic = R.drawable.geschichte;
                        break;
                    case "Kunst":
                        sd.pic = R.drawable.kunst;
                        break;
                    case "Mathe":
                        sd.pic = R.drawable.mathe;
                        break;
                    case "Musik":
                        sd.pic = R.drawable.musik;
                        break;
                    case "Physik":
                        sd.pic = R.drawable.physik;
                        break;
                    case "Physik Üb.":
                        sd.pic = R.drawable.physik;
                        break;
                    case "Religion":
                        sd.pic = R.drawable.religion;
                        break;
                    case "Wirtschaft":
                        sd.pic = R.drawable.wirtschaft;
                        break;
                    case "Chemie":
                        sd.pic = R.drawable.chemie;
                        break;
                    case "Chemie Üb.":
                        sd.pic = R.drawable.chemie;
                        break;

                    case "Biologie":
                        sd.pic = R.drawable.biologie;
                        break;
                    case "Geografie":
                        sd.pic = R.drawable.geografie;
                        break;
                    case "Englisch":
                        sd.pic = R.drawable.englisch;
                        break;

                    default:
                        sd.pic = 0;
                }


                subjects.add(i, sd);
            }


            return subjects;

        }

        return null;
    }
    public List<String> getSubjectsName(){

   /*     List<String> names = new ArrayList<>();
        names.add(0,"german");
        names.add(1,"maths");
        names.add(2,"economy");
        names.add(3,"it");
        names.add(4,"religion");
        names.add(5,"physics");
        names.add(6,"art");
        names.add(7,"music");


        return names;*/
        File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"NewSchool"+
                        File.separator+"Fächer"+ File.separator+"f.txt");

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        List<String> names = null;
        try{
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis,"UTF-8");
            br = new BufferedReader(isr);

            names = new ArrayList<>();

            String line = br.readLine();



            for(int i=0; line!=null; i++){



              //  Log.d(LOG_TAG,br.readLine());
                names.add(i,line);


                line = br.readLine();

            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        if(names != null && names.size() != 0)
        return names;

        return null;
    }



}
